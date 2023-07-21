// ================================ Approcah 1 =========================================================
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        int j = 0;
        ArrayList<String> al = new ArrayList<>();
        int i = 0;
        for(; i < n; i++) {
            if(i - 1 >= 0 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') continue;
            if(s.charAt(i) == ' '){
                al.add(s.substring(j, i).trim());
                j = i;
            }           
        }
        al.add(s.substring(j, i));
        Collections.reverse(al);
        StringBuilder sb = new StringBuilder();
        for(String str : al) {
            sb.append(str.trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

// =========================== Approach 2  ====================================================

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0, j = 0; j < n; i++) {
            if(s.charAt(j) == ' ') {
                while(j < n && s.charAt(j) == ' '){
                    j++;
                    i = j - 1;
                }       
            }else {

                while(j < n && s.charAt(j) != ' ') 
                    j++;
                sb.insert(0, s.substring(i, j).trim()+" ");
            }
        }
        return sb.toString().trim();
    }
}