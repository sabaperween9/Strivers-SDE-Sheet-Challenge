class MyStack {
    Queue<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        int size = q.size();
        if(size == 0)
            return -1;
        while(size != 1) {
            q.offer(q.poll());
            size--;
        }
        return q.poll();
    }
    
    public int top() {
        int size = q.size();
        if(size == 0)
            return -1;
        while(size != 1) {
            q.offer(q.poll());
            size--;
        }
        int data = q.peek();
        q.offer(q.poll());
        return data;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}