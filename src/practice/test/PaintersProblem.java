package practice.test;

public class PaintersProblem {

	static int[] prefixSum;

	static void setSum(int[] arr) {
		int sum = 0;
		prefixSum = new int[arr.length];
		for (int i= 0; i<arr.length; i++) {
			sum += arr[i];
			prefixSum[i] = sum;
		}
	}
	
	static int getSum(int start, int end) {
		if (end > prefixSum.length) end = prefixSum.length;
		if (start <= 0) return prefixSum[end];
		return prefixSum[end] - prefixSum[start-1];
	}
	
	static int solve(int[] arr, int k) {
		setSum(arr);
		
		int n = arr.length;
//		for(int i=0; i<n; i++) {
//			System.out.printf("%d \t", prefixSum[i]);
//		}
		int[][] dp = new int[k+1][n];
		for (int i=0; i<n; i++) {
			dp[1][i] = getSum(0, i);
		}
		for (int i=1; i<=k; i++) {
			dp[i][0] = arr[0];
		}

		for(int i=2; i<=k; i++) {
			for(int j=1; j<n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int p=j; p>0; p--) {
					dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][p-1], getSum(p, j)));
				}
			}
		}
		return dp[k][n-1];
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 60, 50, 30, 40 }; 
		int k = 3;
		System.out.println(solve(arr, k)); 
	}
}




















