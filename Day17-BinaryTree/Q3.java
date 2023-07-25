// ================ Approach -1  ==========================================
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root == null)
            return al;
        al.addAll(postorderTraversal(root.left));
        al.addAll(postorderTraversal(root.right));
        al.add(root.val);
        return al;
    }
}

// ============== Approach-2 using 2 stack ===========================================
 List<Integer> al=new ArrayList<>();
        if(root==null)
            return al;
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        TreeNode curr=root;
        st1.push(curr);
        while(!st1.isEmpty()){    
            curr=st1.pop();
            st2.push(curr);

            if(curr.left!=null) 
                st1.push(curr.left);
            if(curr.right!=null) st1.push(curr.right);
   
        }
        while(!st2.isEmpty()){
            al.add(st2.pop().val);
        }
        return al;

//  ======= Approach - 3 using 1 stack ================================
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al=new ArrayList<>();
        if(root==null)
            return al;
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || curr != null){    
            if(curr == null) 
                curr = st.pop();
            else {
                al.add(curr.val);
                st.push(curr.left);
                curr = curr.right;
            }
        }
        Collections.reverse(al);
        return al;
    }
}

// ============ Approach -4 ===============================================
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al=new ArrayList<>();
        if(root==null)
            return al;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null) {
            if(root != null) {
                st.push(root);
                root = root.left;
            }else  {
                TreeNode temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    al.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        al.add(temp.val);
                    }
                }else 
                    root = st.peek().right;
            }
        }
        return al;
    }
}