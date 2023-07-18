public class Solution {
    public static long ayushGivesNinjatest(int days, int chap, int[] time) {
        
        long high = 0;
         long low = Long.MAX_VALUE;
        for(int x : time) {
            low = Math.min(low, x);
            high += x;
        }
        long res = 0;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(isValid(mid, days, time)) {
                res = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return res;
    }

    static boolean isValid(long limit, int days, int[] time) {
        int dayCount = 1;
        long chapter = 0;

        for(int i = 0; i < time.length; i++) {
            if(time[i] > limit) return false;
            if(chapter + time[i] > limit) {
                dayCount++;
                chapter = time[i];
                if(dayCount > days) return false;
            }else chapter += time[i];
        }

        return dayCount <= days; 
    }
}