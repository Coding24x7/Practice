package practice.pattern;

import java.util.ArrayList;
import java.util.List;

public class ClosestPallindrom {
		private List<Integer> findDigits(int v) {
			List<Integer> d = new ArrayList<Integer>();
			while(v>0) {
				d.add(v%10);
				v = v/10;
			}		
			return d;
		}

		private int getPal(List<Integer> d) {
				int half = (d.size()+1)/ 2;
				int v = 0;

				for(int i=d.size()-1; i>=d.size()-half; i--) {
					v = (10*v) + d.get(i);
				}

				for(int i=half; i< d.size(); i++) {
					v = (10*v) + d.get(i);
				}
				return v;
		}

		private int nextPal(List<Integer> d, int diff) {
				int half = (d.size()+1)/ 2;
				int v = 0;

				for(int i=d.size()-1; i>=d.size()-half; i--) {
					v = (10*v) + d.get(i);
				}
				System.out.println(v + " }}}");
				v = v + diff;
				System.out.println(v + " }}}");
				String vstr = String.valueOf(v);
				StringBuilder sb = new StringBuilder(vstr);
				if(vstr.length() >= d.size()-half) {
					sb.append(new StringBuilder(sb.substring(0, d.size()-half)).reverse());
				} else {
					sb.append("9" + sb.reverse());
				}
				return Integer.valueOf(sb.toString());
		}

		public int find(int v) {
				if (v<10) {
					return v;
				}

				List<Integer> d = findDigits(v);
				System.out.println(d);
				int p = getPal(d);
				System.out.println(p + " ))))");
				int diffParam = 1;
				if (p > v) {
					diffParam = -1;
				}

				d = findDigits(v);
				int p2 = nextPal(d, diffParam);
				System.out.println(p2 + " ))))");
				int diff1 = Math.abs(p - v);
				int diff2 = Math.abs(p2 - v);

				if (diff1 < diff2) {
					return p;
				}
				if (diff2 < diff1) {
					return p2;
				}
				return p<p2?p:p2;
			}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestPallindrom cp = new ClosestPallindrom();
		System.out.println(cp.find(100));
	}

}
