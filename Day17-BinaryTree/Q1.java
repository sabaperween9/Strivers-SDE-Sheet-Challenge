// ================ Approach -1 , Recursion ============================

public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root == null)
            return al;
        al.addAll(inorderTraversal(root.left));
        al.add(root.val);
        al.addAll(inorderTraversal(root.right));
        return al;
    }

// ============== Approach- 2, Iterative ===================================
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root == null)
            return al;
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || curr != null) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            al.add(curr.val);
            curr = curr.right;
        }
        return al;
    }

 
}