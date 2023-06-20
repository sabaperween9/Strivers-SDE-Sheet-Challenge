class Solution {
//==================================== Approach-1 , TC : O(numRows^2) ========================================================== 
    public List<List<Integer>> generate(int numRows) {

       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 1; i <= numRows; i++) {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(1);
			if(i == 1) {
				ans.add(al);
				continue;
			}
			ArrayList<Integer> temp = ans.get(ans.size()-1);
			for(int j = 0; j < temp.size()-1; j++) {
				int x = temp.get(j) + temp.get(j+1);
				al.add(x);
			}
			al.add(1);
			ans.add(al);
		}
		return ans;
    }

// ===========================Approach-2 , TC = TC : O(numRows^2) ===================================================================================

    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans = new ArrayList<>();
		for(int i = 1; i <= numRows; i++) {
            ArrayList<Integer> al = new ArrayList<>();
			int  temp = 1;
            al.add(temp);
            for(int j = 1; j < i; j++) {
                temp *= (i - j);
                temp /= j; 
                al.add(temp);
            }
            ans.add(al);
		}
		return ans;
    }
}