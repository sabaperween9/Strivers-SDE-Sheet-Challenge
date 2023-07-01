
// ===================================== Approach - 1 , TC = O(n) ====================================
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 1)
            return 1;
        int l = 0 , r = 0;
        int len = 0;
        HashMap<Character , Integer> hm = new HashMap<>();
        while(r < n) {
            
            if(hm.containsKey(s.charAt(r))) {
                l = Math.max(l, hm.get(s.charAt(r)) + 1);
               
            }
            len = Math.max(len , r - l + 1);  
            hm.put(s.charAt(r) , r);
            r++;

        }
        return len;
    }
}