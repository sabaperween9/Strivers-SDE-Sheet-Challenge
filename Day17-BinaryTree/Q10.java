class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        Queue<Demo> q = new LinkedList<>();
        q.offer(new Demo(root, 0,0));
        while(!q.isEmpty()) {
            Demo d = q.poll();
            if(!tm.containsKey(d.col)) 
                tm.put(d.col, new TreeMap<>());
            if(!tm.get(d.col).containsKey(d.row))
                tm.get(d.col).put(d.row, new PriorityQueue<>());
            tm.get(d.col).get(d.row).offer(d.node.val);
            if(d.node.left != null) 
                q.offer(new Demo(d.node.left, d.row + 1, d.col - 1));
            if(d.node.right != null) 
                q.offer(new Demo(d.node.right, d.row + 1, d.col + 1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> t : tm.values()) {
            list.add(new ArrayList<>());
            int n = list.size();
            for(PriorityQueue<Integer> p : t.values()) {
                while(!p.isEmpty()) {
                    list.get(n - 1).add(p.poll());
                }
            }
        }

        return list;
    }
}

class Demo {
    TreeNode node;
    int row;
    int col;
    Demo(TreeNode node , int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}