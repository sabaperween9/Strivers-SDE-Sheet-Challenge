class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int e1 = m + n - 1;
        int e2 = n - 1;
        int s1 = m - 1;

        while(s1 >= 0 && e2 >= 0) {
            if(nums1[s1] <= nums2[e2]) {
                nums1[e1--] = nums2[e2--];
            }else{
                nums1[e1--] = nums1[s1--];
            }
        }

        while(e2 >= 0) {
            nums1[e1--] = nums2[e2--];
        }
    }
}