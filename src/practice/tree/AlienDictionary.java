package practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AlienDictionary {

	private class Node {
		boolean[] nArr;
		
		Node(int k) {
			nArr = new boolean[k];
		}
		void set(int n) {
			nArr[n]= true;
		}
	}

	boolean[] found;
	Node[] root;
	int treeSize;
	int k;

	AlienDictionary(int k) {
		root = new Node[k];
		found = new boolean[k];
		treeSize = 0;
		this.k = k;
	}

	private void addOrder(char c1, char c2) {
		int id1 = c1 - 'a';
		int id2 = c2 - 'a';

		if (!found[id1]) {
			found[id1] = true;
			treeSize++;
		}
		
		if (!found[id2]) {
			found[id2] = true;
			treeSize++;
		}

		Node n = root[id1];
		if (n == null) {
			n = new Node(k);
			root[id1] = n;
		}
		n.set(id2);
	}

	private void setOrder(String s1, String s2) {
		int len = Math.min(s1.length(), s2.length());
		for (int i=0; i< len; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				addOrder(s1.charAt(i), s2.charAt(i));
				break;
			}
		}
	}

	private void dfs(int n, Stack<Character> st, boolean[] visited) {
		Node nd = root[n];
		if (nd == null) return;
		
		visited[n] = true;
		
		for(int i=0; i<k; i++) {
			if(!visited[i] && nd.nArr[i]) {
				dfs(i, st, visited);
				st.add((char)('a'+i));
			}
			
		}
		st.add((char)('a'+n));
	}

	private String topoSort() {
		Stack<Character> st = new Stack<Character>();
		boolean[] visited = new boolean[k];
		
		for(int i=0; i<k; i++) {
			if (!visited[i]) {
				dfs(i, st, visited);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.toString();
	}
	
	private String notFound() {
		StringBuilder sb = new StringBuilder();
		for(int i =0; i< k; i++) {
			if (!found[i]) {
				sb.append('a'+i);
			}
		}
		return sb.toString();
	}

	public String solve(String[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			setOrder(arr[i], arr[i+1]);
		}

		return topoSort() + notFound();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 4;
		AlienDictionary ad = new AlienDictionary(k);
		String[] arr = new String[] {"baa", "abcd", "abca", "cab", "cad"};
		System.out.println(ad.solve(arr));
	}

}
