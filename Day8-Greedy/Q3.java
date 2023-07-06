

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr , new Comparator<Job>() {
            public int compare(Job a , Job b) {
                    return b.profit - a.profit ;
            }
        });
        boolean[] isValid = new boolean[n + 1]; 
        int profit = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!isValid[arr[i].deadline]) {
                isValid[arr[i].deadline] = true;
                profit += arr[i].profit;
                count++;
            }else {
                int j = arr[i].deadline - 1;
                while(j > 0) {
                    if(!isValid[j]) {
                        isValid[j] = true;
                        profit += arr[i].profit;
                        count++;
                        break;
                    }
                    j--;
                }
            }
        }
        
        return new int[]{count, profit};
    }
}
