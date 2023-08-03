class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int n = q.size();
            int start = 0,  end = 0;
            for(int i = 0; i < n; i++) {
                Pair curr = q.poll();
                if(i == 0)
                    start = curr.ref;
                if(i == n - 1)
                    end = curr.ref;
                if(curr.node.left != null) 
                    q.offer(new Pair(curr.node.left, 2 * curr.ref + 1));
                
                if(curr.node.right != null) 
                    q.offer(new Pair(curr.node.right, 2 * curr.ref + 2));
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}

class Pair {
    TreeNode node;
    int ref;
    Pair(TreeNode node , int ref) {
        this.node = node;
        this.ref = ref;
    }
}
