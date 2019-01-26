package practice.pattern;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class Matcher {

		int curState;
		int finalState;
		int[][] table;
		int R = 128;

		public Matcher(char[] pattern) {
			generateTable(pattern);
			curState = 0;
			finalState = pattern.length;
		}

		public Matcher(String pattern) {
			this(pattern.toCharArray());
		}

		private void generateTable(char[] pattern) {
			int totalStates = pattern.length + 1;
			table = new int[R][totalStates];

			int state = 0;
			int badState = 0;

			for(int i=0; i < pattern.length; i++) {
				if (state > 0) {
					for (int j=0; j < R; j++) {
						table[j][state] = table[j][badState];
					}
					badState = table[pattern[i]][badState];
				}

				table[pattern[i]][state] = state + 1;
				state ++;
				
			}
		}

		private boolean run(char c) {
			curState = table[c][curState];
			if (curState == finalState) {
				return true;
			}
			return false;
		}

		public void print() {
			System.out.print("   ");
			for (int j=0; j<=finalState; j++) {
				System.out.print(j + " ");
			}
			System.out.println("");

			for(int i=0; i < R; i++) {
				System.out.print((char)i + " ");
				for(int j=0; j<finalState; j++) {
					System.out.print(table[i][j] + " ");
				}
				System.out.println("");
			}
		}


	public int match(String text) {
		if (text.length() < finalState) {
			return -1;
		}

		 for (int i=0; i<text.length(); i++) {
			 if(run(text.charAt(i))) {
				 return i-finalState + 1;
			 }
		 }
		 return -1;
	}

	public int match(InputStream is) throws IOException {
		int next = is.read();
		int i = 0;
		while(next >= 0) {
			if(run((char) next)) {
				 return i-finalState + 1;
			 }
			next = is.read();
			i++;
		}

		 return -1;
	}

	public static void main(String[] args) throws IOException {
		String text = "abcdefghabacde";
		String pattern = "abacde";

		Matcher matcher = new Matcher(pattern);
		System.out.println(matcher.match(text));
		InputStream is = new StringBufferInputStream(text);
		System.out.println(matcher.match(is));
	}

}
