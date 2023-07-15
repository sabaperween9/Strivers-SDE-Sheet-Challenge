class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0,high = n1;
        while(low <= high){
          int cnt1 = low + (high-low) / 2;
          int cnt2 = (n1+n2+1) / 2 - cnt1;

          int left1 = cnt1 == 0? Integer.MIN_VALUE : nums1[cnt1-1];
          int left2 = cnt2 == 0? Integer.MIN_VALUE : nums2[cnt2-1];

          int right1 = cnt1 == n1? Integer.MAX_VALUE : nums1[cnt1];
          int right2 = cnt2 == n2? Integer.MAX_VALUE : nums2[cnt2];

          if(left1 <= right2 && left2 <= right1){
              if((n1 + n2) % 2 == 0)
                return ((Math.max(left1,left2) + Math.min(right1,right2)) * 1.0)/2;
                return Math.max(left1,left2);
          }
          else if(left1 > right2) high = cnt1 - 1;
          else low = cnt1 + 1;

        }
        return 0.0;
    }
}

