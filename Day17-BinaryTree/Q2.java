// ===================== Approach - 1, recursive ============================

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root == null)
            return al;
        al.add(root.val);
        al.addAll(preorderTraversal(root.left));
        al.addAll(preorderTraversal(root.right));
        return al;
    }
}

// ===================== Approach - 2, Iterative ============================

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root == null)
            return al;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            al.add(curr.val);
            if(curr.right != null)
                st.push(curr.right);
            if(curr.left != null)
                st.push(curr.left);
        }
        return al;
    }
}