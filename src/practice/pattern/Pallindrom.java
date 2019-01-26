package practice.pattern;

public class Pallindrom {

	public int form(String s) {
		int l = s.length();
		if (l < 2) {
			return 0;
		}

		if (l == 2) {
			if(s.charAt(0) == s.charAt(1)) {
				return 0;
			}
			return 1;
		}

		boolean[][] dp = new boolean[l][l];

		for(int i=0; i<l; i++) {
			dp[i][i] = true;
			if (i == 0 ) {
				continue;
			}

			dp[i-1][i]= s.charAt(i-1) == s.charAt(i);
		}

		int sz = dp[l-2][l-1]? 2: 1;

		for (int i=0; i<l-2; i++) {
			for(int j=i+2; j<l; j++) {
				dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1]);
//				System.out.printf("%d %d %b \n", i, j, dp[i][j]);
			}
			sz = dp[i][l-1]? l-i: sz;
		}
//		System.out.println(sz);
		return l-sz;
	}

	public static void main(String[] args) {
		String s = "acecdce";
		Pallindrom p = new Pallindrom();
		System.out.println(p.form(s));
	}
}

