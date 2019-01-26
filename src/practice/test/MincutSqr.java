package practice.test;

public class MincutSqr {

	public static int find(int x, int y) {
		if (x == y) return 1;
	
		int min = Math.min(x, y);
		int max = Math.max(x, y);

		int res = 0;
		while(min != 0) {
			res += max / min;
			int temp = max;
			max = min;
			min = temp%min;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find(30, 35));
	}

}
