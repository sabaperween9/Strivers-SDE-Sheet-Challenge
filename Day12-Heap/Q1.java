public class Solution {

 static int[] minHeap(int n, int[][] q) {
       // Write your code here.
       int cnt =0;
       for(int i=0;i<q.length;i+=1){
           if(q[i][0]==1)
               cnt+=1;
       }
       int res[] = new int[cnt];
       int i=0;
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int[] a : q){
           if(a[0] == 0){
               pq.offer(a[1]);
           }
           if(a[0] == 1){
               res[i]= pq.poll();
               i++;
           }
       }
       return res;
   }
}