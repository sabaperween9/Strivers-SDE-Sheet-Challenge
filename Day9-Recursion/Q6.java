// ============================ Approach - 1 =========================================
class Solution {
    public String getPermutation(int n, int k) {
        int[] count = new int[1];
        count[0] = k;
        boolean[] isVisited = new boolean[n + 1];
        ArrayList<String> al = new ArrayList<>();
        helper(n, new StringBuilder(), isVisited ,al, count);
        return al.get(al.size() - 1);
    }

    void helper(int n, StringBuilder sb , boolean[] isVisited, ArrayList<String> al, int[] count) {
        if(sb.length() == n){
            count[0]--;
            al.add(sb.toString());
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(count[0] == 0) break;
            if(!isVisited[i]) {
                isVisited[i] = true;
                sb.append(i);
                helper(n, sb, isVisited, al, count);
                sb.deleteCharAt(sb.length() - 1);
                isVisited[i] = false;
            }
        }
    }
}

// ====================== Approach - 2==================================================

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            fact *= i;
            al.add(i);
        }
        al.add(n);
        StringBuilder sb = new StringBuilder();
        k = k - 1;
        while(true) {
            sb.append(al.get(k / fact));
            al.remove(k / fact);
            if(al.size() == 0) break;
            k = k % fact;
            fact = fact / al.size(); 
        }

        return sb.toString();
    }
}