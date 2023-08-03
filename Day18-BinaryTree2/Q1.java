lass Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> al = new ArrayList<>();
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                al.add(curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            ans.add(al);
        }
        return ans;
    }
}
