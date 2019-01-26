package practice.pattern;

import java.util.Arrays;

public class UniqueCharsWindow {
	int MAX_CHARS = 256;

	private int findUniqCount(String str) {
		int cnt = 0;
		if (str.length() < 1) {
			return 0;
		}

		boolean[] arr = new boolean[MAX_CHARS];
		for(int i=0; i<str.length(); i++) {
			int c = str.charAt(i);
			if (!arr[c]) {
				arr[c] = true;
				cnt++;
			}
		}
		return cnt;
	}

	public String solve(String str) {
		int uc = findUniqCount(str);
		if (uc == 0) {
			return "";
		}
		int[] pos = new int[MAX_CHARS];
		Arrays.fill(pos, -1);
		int start = 0;
		pos[str.charAt(0)] = 0;
		int currentULen = 1;
		if (currentULen == uc) {
			return str.substring(0, uc);
		}
		
		for (int i=1; i< str.length(); i++) {
			int c = str.charAt(i);
			if (pos[c] >= start) {
				start = pos[c] + 1;
				currentULen = i - start + 1;
			} else {
				currentULen++;
			}
			if (currentULen == uc) {
				return str.substring(start, i+1);
			}
			pos[c] = i;
		}
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1100a01101";
		UniqueCharsWindow solver = new UniqueCharsWindow();
		System.out.println(solver.solve(str));
	}
}
