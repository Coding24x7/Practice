package practice.pattern;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FivePower {

	private int[] getEndIndices(String str) {
		int l = str.length();
		int[] idx = new int[l/3];
		Arrays.fill(idx, -1);
		boolean startPattern = false, inPattern = false;
		int i = 0;
		for (int j=0; j<l; j++) {
			if (!startPattern) {
				if (str.charAt(j) == '1') {
					startPattern = true;
				}
				continue;
			}

			if (inPattern) {
				if (str.charAt(j) == '1') {
					idx[i++] = j;
					inPattern = false;
				}
				continue;
			}
			if (str.charAt(j) == '0') {
				inPattern = true;
			}
		}
		return idx;
	}

	private boolean isPower(long value, int base) {
		while(value > 1) {
			if(value % base != 0) {
				return false;
			}
			value = value/base;
		}
		return true;
	}

	public int solve(String str) {
		int len = str.length();
		if (len <= 2) {
			return -1;
		}

		 
		if (str.charAt(len-1) != '1' || str.charAt(len-2) != '0') {
			return -1;
		}
		
		int[] endPos = new  int[len];
		int[] dp = new int[len];

		Arrays.fill(endPos, -1);
		Arrays.fill(dp, -1);

		endPos[len-1] = -1;
		endPos[len-2] = -1;

		int lastOneIdx = len-1;

		boolean inPattern = true;
		for (int j=len-3; j>=0; j--) {
			if(str.charAt(j) == '0') {
				endPos[j] = endPos[j+1];
				inPattern = true;
				continue;
			} 

			if (inPattern) {
				inPattern = false;
				endPos[j] = lastOneIdx;
			} else {
				endPos[j] = endPos[j+1];
			}
				
			lastOneIdx = j;
			
			
			if (endPos[j] == -1) {
				continue;
			}

			long value = 0;
			int pos = endPos[j];
			dp[j] = Integer.MAX_VALUE;

			for (int k=j; k<len; k++) {
				value = (value * 2) + (long)(str.charAt(k)-'0');
				if (k == pos) {
					if (isPower(value, 5)) {
						if (k == len-1) {
							dp[j] = 0;
						} else if (dp[k+1] > -1) {
							dp[j] = Math.min(dp[j], dp[k+1] + 1);
						}
					}
					pos = endPos[pos];
				}
			}
			if (dp[j] == Integer.MAX_VALUE) {
				dp[j] = -1;
			}
			
		}
		
		return dp[0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "11001101";
		FivePower fv = new FivePower();
		System.out.println(fv.solve(str));
	}

}
