class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, n, new ArrayList<>(), ans, new boolean[n][n]);
        return ans;
    }

    void helper(int index, int n, List<String> al, List<List<String>> ans, boolean[][] isVisited) {

        if(index == n) {
            ans.add(new ArrayList<>(al));
            return;
        }

        for(int i = 0; i < n; i++) {

            if(!isVisited[index][i]) {
                if(isValid(index, i, isVisited)) {
                    String str = ansString(i, n);
                    isVisited[index][i] = true;
                    al.add(str);
                    helper(index + 1, n, al, ans, isVisited);
                    isVisited[index][i] = false;
                    al.remove(al.size() - 1);
                }
            }

        }
    }

    boolean isValid(int row, int col, boolean[][] isVisited) {
        int n = isVisited.length;
        for(int i = row - 1; i >= 0; i--) {
            if(isVisited[i][col]) return false;
        }
        int i = row - 1, j = col - 1;
        while(i >= 0 && j >= 0) {
            if(isVisited[i][j])
                return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < n) {
            if(isVisited[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }

    String ansString(int index, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(i == index)
                sb.append('Q');
            else
                sb.append('.');
        }
        return sb.toString();
    }
}