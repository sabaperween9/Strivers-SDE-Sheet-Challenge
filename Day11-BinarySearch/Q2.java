public final class Solution {
    public static int findMedian(int [][] A, int m, int n) {
        int low = 1;
        int high = (int)Math.pow(10, 9);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += countOperation(A[i], mid, n);
            }
            if (cnt <= (n * m) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

     public static int countOperation(int[] A, int mid, int n) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int md = l + (h - l) / 2;
            if (A[md] <= mid)
                l = md + 1;
            else 
                h = md - 1;
        }
        return l;
    }
}