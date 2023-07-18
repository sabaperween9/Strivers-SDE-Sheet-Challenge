import java.util.*;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        
        int n = stalls.length;
        if(n < k) return -1;
        Arrays.sort(stalls);
        int low = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int x : stalls) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int res = 0;
        int high = max - min;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(mid, stalls, k)) {
                res = mid;
                low = mid + 1;  
            }else high = mid - 1;
        }

        return res;
    }

    static boolean isPossible(int limit, int[] stalls, int k) {

        int cowCount = 1;
        int lastPos = stalls[0];
        for(int i = 1; i < stalls.length; i++) {
            if(stalls[i] - lastPos >= limit) {
                cowCount++;
                if(cowCount == k) return true;
                lastPos = stalls[i];
            }
        }
        return false;
    }
}