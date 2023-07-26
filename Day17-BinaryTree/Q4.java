// ======================= Morris Inorder Traversal ======================================
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null) {

            if(curr.left == null) {
                al.add(curr.val);
                curr = curr.right;
            }else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) 
                    prev = prev.right;
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }else {
                    prev.right = null;
                    al.add(curr.val);
                    curr = curr.right;
                }
            }

        }
        return al;
    }
}