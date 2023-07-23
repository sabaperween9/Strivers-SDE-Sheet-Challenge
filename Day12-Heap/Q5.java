import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
// ================= TC = O(n log k), where 'n' is the total number of elements across all 'k' lists, and 'k' is the number of lists.
class Node {
	int index;
	int noList;
	int value;
	Node(int index,int noList, int value) {
		this.index = index;
		this.noList = noList;
		this.value = value;
	}
}
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> al, int k) {
		if(k == 0) 
			return new ArrayList<>(); 
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.value - n2.value;
			}
		});
		for(int i = 0; i < k; i++) {
			Node node = new Node(0,i,al.get(i).get(0));
			pq.offer(node);
		}
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index = node.index;
			int noList = node.noList;
			int value = node.value;
			ans.add(value);
			if(index + 1 < al.get(noList).size()) 
				pq.offer(new Node(index + 1, noList, al.get(noList).get(index + 1)));
		}
		return ans;
	}
}

