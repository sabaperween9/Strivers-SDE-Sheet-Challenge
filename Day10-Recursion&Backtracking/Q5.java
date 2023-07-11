class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> al = new ArrayList<>();
        helper(0, 0, m, visited, al, "");
        return al;
         
    }
    
    public static void helper(int row, int col, int[][] m, boolean[][] visited, ArrayList<String> al, String str) {
        if(row < 0 || col < 0 || row >= m.length || col >= m.length || visited[row][col] || m[row][col] == 0)
            return;
        if(row == m.length - 1 && col == m.length -1) {
            al.add(str);
            return;
        }
        
        visited[row][col] = true;
        helper(row - 1, col, m, visited, al, str + "U");
        helper(row, col + 1, m, visited, al, str + "R");
        helper(row + 1, col, m, visited, al, str + "D");
        helper(row, col - 1, m, visited, al, str + "L");
        visited[row][col] = false;
    }
}