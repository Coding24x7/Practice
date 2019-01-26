package practice.test;

import java.util.HashSet;
import java.util.Set;

public class TSP {

	static int findMinCost(int v, int[][] costs, Set<Integer> visited) {
		visited.add(v);
		if (visited.size() == costs.length-1) {
			return costs[v][0];
		}

		int cost = Integer.MAX_VALUE;

		for(int i=1; i< costs.length; i++) {
			if (!visited.contains(i) && costs[v][i] > 0) {
				cost = Math.min(cost, findMinCost(i, costs, visited)+costs[v][i]);
			}
		}

		visited.remove(v);
		return cost;
	}

	static int solve(int[][] costs) {
		int cost = Integer.MAX_VALUE;
		Set<Integer> visited = new HashSet<Integer>();
		for(int i=1; i< costs.length; i++) {
			if (costs[0][i] > 0) {
				cost = Math.min(cost, findMinCost(i, costs, visited)+costs[0][i]);
			}
		}
		return cost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int[][]{
			{0, 2, 3, 4},
			{0, 0, 2, 5},
			{1, 2, 0, 4},
			{1, 1, 2, 0}
//			{0, 1000, 5000},
//			{5000, 0, 1000},
//			{1000,  5000,  0}
		};
		System.out.println(solve(arr));
	}

}
