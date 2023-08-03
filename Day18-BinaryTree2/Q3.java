class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return ans;
        solve(root);
        return ans;
    }

    public int solve(TreeNode root) {
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
            return 0;
        int left = solve(root.left) + 1;
        int right = solve(root.right) + 1;
        ans = Math.max(ans , left + right);
        return Math.max(left, right);
    }
}

