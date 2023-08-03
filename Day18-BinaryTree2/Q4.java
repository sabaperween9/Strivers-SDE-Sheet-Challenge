class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int isBalanced = solve(root);
        return isBalanced != -1;
    }

    public int solve(TreeNode root) {
        if(root == null)
            return 0;
        int left = solve(root.left);
        if(left == -1) return -1;
        
        int right = solve(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}