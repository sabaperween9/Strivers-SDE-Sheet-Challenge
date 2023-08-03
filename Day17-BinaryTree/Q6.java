class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> al = new ArrayList<>();
      if(root == null)
        return al;
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      while(!q.isEmpty()) {
          int size = q.size();
          for(int i = 0; i < size; i++) {
              
              Node temp = q.poll();
              
              if(i == 0)
                al.add(temp.data);
                
              if(temp.left != null)
                q.offer(temp.left);
              
              if(temp.right != null)
                q.offer(temp.right);
          }
      }
      return al;
    }
}
