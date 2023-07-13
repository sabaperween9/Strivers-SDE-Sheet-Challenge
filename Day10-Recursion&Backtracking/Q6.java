import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		
		ArrayList<String> al = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();
		for(String x : dictionary)
			hs.add(x);
		helper(0, s, al, hs, new ArrayList<>());
		return al;

	}

	static void helper(int index, String s, ArrayList<String> ans, HashSet<String> dic, ArrayList<String> temp) {

		 if(index == s.length()) {
			StringBuilder sb = new StringBuilder();
			for(String x : temp) {
				sb.append(x);
				sb.append(" ");
			}
			ans.add(sb.toString().trim());
			return;
		 }

		 for(int i = index; i < s.length(); i++) {
			 String str = s.substring(index, i + 1);
			 if(dic.contains(str)) {
				temp.add(str);
			    helper(i + 1, s, ans, dic, temp);
				temp.remove(temp.size() - 1);
			 }
		 }

	}
}