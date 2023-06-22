// =========================Approach - 1 , TC = O(n) , sc = O(n) ========================================================================
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x : nums) {
             hm.put(x , hm.getOrDefault(x , 0) + 1);
             if(hm.get(x) > n /3 && !al.contains(x))
                al.add(x);
        }
        return al;
    }
}

// =========================Approach - 2 , TC = O(n) , SC = O(1) =====================================================================

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> al = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE , count1 = 0, count2 = 0;
        for(int i = 0; i < n; i++) {
            if(count1 == 0 && nums[i] != ele2) {
                count1++;
                ele1 = nums[i];
            }else if(count2 == 0 && nums[i] != ele1) {
                count2++;
                ele2 = nums[i];
            }else if(ele1 == nums[i])
                count1++;
            else if(ele2 == nums[i])
                count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1  = 0;
        count2 = 0;
        for(int x : nums) {
            if(x == ele1) count1++;
            else if(x == ele2) count2++;
        }
        if(count1 > n / 3)
            al.add(ele1);
        if(count2 > n / 3)
            al.add(ele2);
        return al;
    }
}