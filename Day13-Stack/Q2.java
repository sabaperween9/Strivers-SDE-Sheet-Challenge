public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = -1;
            rear = -1;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
           if(rear + 1 == arr.length)
                return;
            if(front == -1) front++;
            arr[++rear] = e;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if(front == -1)
                return -1;
            int data = arr[front];
            for(int i = front; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            if(rear == -1) front = -1;
            return data;
        }
    }
}