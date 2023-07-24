class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
         int n2 = nums2.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n2 - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums2[i] > st.peek()) {
                st.pop();
            }
            if(st.isEmpty()) 
                hm.put(nums2[i], -1);
            else 
                hm.put(nums2[i], st.peek());

            st.push(nums2[i]);
        }
        int n1 = nums1.length;
        int[] ans = new int[n1];
        for(int i = 0; i < n1; i++) {
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}