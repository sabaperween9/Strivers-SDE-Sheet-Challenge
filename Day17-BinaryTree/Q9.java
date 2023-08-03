public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
      
	   List<List<Integer>> al = new ArrayList<>();
	   if(root == null)
	   		return al;
	   for(int i = 0; i < 3; i++)
	   		al.add(new ArrayList<>());
	   Stack<Demo> st = new Stack<>();
	   st.push(new Demo(root, 1));
	   while(!st.isEmpty()) {
		   Demo temp = st.peek();
		   if(temp.ref == 1) {
			   st.peek().ref++;
				al.get(1).add(temp.node.data);
				if(temp.node.left != null) {
					st.push(new Demo(temp.node.left, 1));
				}
		   }else if(temp.ref == 2) {
			   st.peek().ref++;
			   al.get(0).add(temp.node.data);
			   if(temp.node.right != null) {
					st.push(new Demo(temp.node.right, 1));
				}
		   }else {
			   al.get(2).add(temp.node.data);
			   st.pop();
		   }
	   }
	   return al;
    }
}

class Demo {
	BinaryTreeNode<Integer> node;
	int ref;
	Demo(BinaryTreeNode<Integer> node, int ref) {
		this.node = node;
		this.ref = ref;
	}
}
