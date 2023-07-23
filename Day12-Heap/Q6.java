class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x : nums) 
            hm.put(x, hm.getOrDefault(x,0) + 1);
        int[] ans = new int[k];
        PriorityQueue<Node> pq = new PriorityQueue<>((n1 , n2) -> n1.freq - n2.freq);
        for(Map.Entry<Integer, Integer> mp : hm.entrySet()) {
            if(pq.isEmpty() || pq.size() < k) 
                pq.offer(new Node(mp.getKey(), mp.getValue()));
            else {
                if(mp.getValue() > pq.peek().freq){
                    pq.poll();
                    pq.offer(new Node(mp.getKey(),mp.getValue()));
                }       
            }
        }
        int i = 0;
        while(!pq.isEmpty()) {
            ans[i++] = pq.poll().data;
        }
        return ans;
    }
}
class Node {
    int data;
    int freq;
    Node(int data, int freq) {
        this.data = data;
        this.freq = freq;
    }
}