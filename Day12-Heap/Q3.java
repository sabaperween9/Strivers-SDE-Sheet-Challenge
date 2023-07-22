// ======================== Approach -1 TC = O(n^2)=========================================================
import java.util.*;
public class Solution {
    public static int[] findMedian(int[] arr, int m) {
       
       ArrayList<Integer> al = new ArrayList<>();
       al.add(arr[0]);
       for(int i = 0; i < m - 1; i++) {
           int j = i + 1;
           for(; j > 0; j--) {
               if(arr[j] < arr[j - 1]) {
                   int temp = arr[j];
                   arr[j] = arr[j - 1];
                   arr[j - 1] = temp;
               }else {
                   break;
               }
           }
           int n = i + 2;
           if(n % 2 == 0) {
               int add = (arr[n / 2] + arr[n / 2 - 1]) / 2;
               al.add(add);
           }else {
               al.add(arr[n / 2]);
           }
       }
       int[] ans = new int[al.size()];
       for(int i = 0; i < al.size(); i++) {
           ans[i] = al.get(i);
       }
       return ans; 
    }
}

// ==================== Approach - 2  TC = O(nlogn)  =============================================================

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        int[] ans = new int[n];
        ans[0] = arr[0];
        max.offer(arr[0]);
        for(int i = 1; i < n; i++) {
            if(max.isEmpty() || max.peek() > arr[i])
                max.offer(arr[i]);
            else min.offer(arr[i]);
            
            if(max.size() > min.size() + 1) 
                min.offer(max.poll());
            else if(min.size() > max.size() + 1) 
                max.offer(min.poll());
            
            int size = i + 1;
            if(size % 2 == 0) {
               ans[i] = (max.peek() + min.peek()) / 2; 
            }else {
                if(max.size() > min.size())
                    ans[i] = max.peek();
                else ans[i] = min.peek();
            }
            
        }
        return ans;        
    }
}


