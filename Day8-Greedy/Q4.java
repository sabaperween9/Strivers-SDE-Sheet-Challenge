// =================== TC = O(n) ================================================
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        
        Arrays.sort(arr , (Item a , Item b) -> (b.value * a.weight) - (a.value * b.weight));
        double ans = 0;
        int i = 0;
        while(W != 0 && i < n) {
            if(arr[i].weight <= W) {
                ans += arr[i].value;
                W -= arr[i].weight;
            }else {
                ans += (((double)arr[i].value / (double)arr[i].weight) * (double)W);
                break;
            }
            
            i++;
        }
        return ans;
        
    }
}
