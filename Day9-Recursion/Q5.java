class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(String str, int index, List<String> al, List<List<String>> ans) {
        if(index == str.length()){
            ans.add(new ArrayList<>(al));
            return;
        }
    
        for(int i = index; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str.substring(index, i + 1));
            if(!isPalindrom(sb)) continue;
            al.add(sb.toString());
            helper(str, i + 1, al, ans);
            al.remove(al.size() - 1);
        }


    }

    boolean isPalindrom(StringBuilder sb) {
        StringBuilder str = new StringBuilder(sb);
        sb.reverse();
        return sb.toString().equals(str.toString());
    }
}