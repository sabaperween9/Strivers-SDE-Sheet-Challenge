// ================ TC = O(K log K +  (N – K) log K) ===============================
class Solution {
    public int findKthLargest(int[] nums, int k) {
      
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.poll();
    }
}
