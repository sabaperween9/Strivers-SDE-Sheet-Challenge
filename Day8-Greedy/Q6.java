// =========== TC = O(n) , SC = O(2*n) ==================================================================
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] meeting = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            meeting[i][0] = start[i];
            meeting[i][1] = end[i];
        }
        
        Arrays.sort(meeting, (int[] a , int[] b) -> a[1] - b[1]);
        
        int count = 1;
        int[] prev = meeting[0];
        int i = 1;
        while(i < n) {
            int[] curr = meeting[i];
            if(curr[0] > prev[1]) {
                count++;
                prev = curr;
            }
            i++;
        }
        return count;
    }
}