//  =====================================Approach - 1 , TC : O(row) ==============================================
class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);   // lambda expression is used
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= ans.get(ans.size() - 1)[1]) {
                if(intervals[i][1] >= ans.get(ans.size() - 1)[1])
                    ans.get(ans.size() - 1)[1] = intervals[i][1];
            }else {
                ans.add(intervals[i]);
            }
        }
        int[][] arr = new int[ans.size()][2];
        for(int i = 0; i < arr.length; i++) {
            arr[i][0] = ans.get(i)[0];
            arr[i][1] = ans.get(i)[1];
        }  
        return arr; 
    }
}

// ==============================Approach - 2 , TC = O(row) ==============================================================

class Solution {

    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int[] f,int[] s){
                return f[0] - s[0];
            }
        });

        ArrayList<int[]> al=new ArrayList<>();
        int[] temp1 = arr[0];
        for(int i = 1; i < arr.length; i++){

            int[] temp2 = arr[i];
            if(temp1[1] >= temp2[0]){
                temp1[1] = Math.max(temp1[1], temp2[1]);
            }else{
                al.add(temp1);
                temp1=temp2;
            }

        }
        al.add(temp1);
        int n = al.size();
        int[][] res  =new int[n][2];
        for(int i = 0; i < n; i++){
            res[i] = al.get(i);
        }

        return res;
    }
}