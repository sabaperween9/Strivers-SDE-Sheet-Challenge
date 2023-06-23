class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(n <= 3){
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0; i+3 < n; i++) {
            for(int j = i + 1; j+2 < n; j++) {
                long target2 = (long)target - (long)nums[i] - (long)nums[j];
                int left = j + 1 , right = n -1;
                while(left < right) {
                    long sum = (long)nums[left] + (long)nums[right];
                    if(sum == target2) {
                        List<Integer> al = new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[left]);
                        al.add(nums[right]);
                        list.add(al);
                        while(left < right && nums[left] == nums[left + 1] ) left++;
                        while(right > left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }else if (sum < target2) left++;
                    else right--;
                }

                while(j+2 < n && nums[j] == nums[j+1]) j++; 
            }

            while(i+3 < n  && nums[i] == nums[i+1]) i++; 
        }
        return list;
    }
}