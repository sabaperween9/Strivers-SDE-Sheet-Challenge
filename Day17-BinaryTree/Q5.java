public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	List<Integer> al = new ArrayList<>();

		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				al.add(curr.data);
				curr = curr.right;
			}else  {
				TreeNode temp = curr.left;
				while(temp.right != null && temp.right != curr)
					temp = temp.right;
				if(temp.right == null) {
					temp.right = curr;
					al.add(curr.data);
					curr = curr.left;
				}else {
					temp.right = null;
					curr = curr.right;

				}
			}
		}

		return al;
    }
}