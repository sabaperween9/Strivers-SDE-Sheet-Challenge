// =================== TC = O(nlogn + n) =========================================

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platformNeeded = 1 , res = 1;
        int i = 0;
        int j = 1;
        
        
        while(i < n && j < n) {
            if(arr[j] <= dep[i]) {
                platformNeeded++;
                j++;
            }else {
                platformNeeded--;
                i++;
            }
            if(platformNeeded > res)
                res = platformNeeded;
        }
        
        return res;
    }
    
}
