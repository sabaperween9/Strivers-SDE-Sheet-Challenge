// ================================== Approach - 1 , TC = O(n) =================================================================
class GfG
{
    int maxLen(int arr[], int n)
    {
        int ans = 0; 
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0 , -1);
        int prefixSum = 0;    
        for(int i = 0; i < n; i++) {  
            prefixSum += arr[i];
            if(hm.containsKey(prefixSum)) {
                int temp = i - hm.get(prefixSum) ;
                ans = Math.max(temp , ans);
            }
            
            if(!hm.containsKey(prefixSum)) {
                hm.put(prefixSum , i);
            } 
        }
        return ans;
    }
}