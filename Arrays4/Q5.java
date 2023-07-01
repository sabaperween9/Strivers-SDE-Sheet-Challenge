public class Solution {
    public int solve(ArrayList<Integer> arr, int x) {
       int n = arr.size();
		HashMap<Integer , Integer> hm = new HashMap<>();
		hm.put(0 , 1);
		int count = 0;
		int xr = 0;

		for(int i = 0; i < n; i++) {
			xr ^= arr.get(i);
			if(hm.containsKey(xr^x))
				count += hm.get(xr^x);
			hm.put(xr , hm.getOrDefault(xr , 0) + 1);
		}
		return count;
    }
}