
public class Solution{
    static class Stack {
        int[] arr;
        int size;
        int top;
        Stack(int capacity) {
           arr = new int[capacity];
           size = 0;
           top = -1;
        }
        public void push(int num) {
            if(size == arr.length)
                return;
            arr[++top] = num;
            size++;
        }
        public int pop() {
            if(size == 0)
                return -1;
            size--;
            return arr[top--];
        }
        public int top() {
            if(top == -1)
                return -1;
            return arr[top];
        }
        public int isEmpty() {
            if(size == 0)
                return 1;
            return 0;
        }
        public int isFull() {
            if(size == arr.length)
                return 1;
            return 0;
        }
    }
}
