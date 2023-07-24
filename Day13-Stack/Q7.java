
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		int data = stack.pop();
		sortStack(stack);
		Stack<Integer> temp = new Stack<>();

			while(!stack.isEmpty() && data < stack.peek()){
				temp.push(stack.pop());
			}
			stack.push(data);
			while(!temp.isEmpty()) {
				stack.push(temp.pop());
			}
		
	}

}