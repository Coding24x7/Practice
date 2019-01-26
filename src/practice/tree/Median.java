package practice.tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median {

	private class IntComp implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
		
	}

	private Queue<Integer> minHeap;
	private Queue<Integer> maxHeap;
	private int minHeapSize;
	private int maxHeapSize;

	public Median() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(new IntComp());
		minHeapSize = 0;
		maxHeapSize = 0;
	}
	
	public float findMedian(int val) {
		if (minHeapSize == maxHeapSize) {
			if (maxHeapSize == 0) {
				maxHeap.add(val);
				maxHeapSize++;
				return val;
			}
			int temp = val;
			if(minHeap.peek() < val) {
				temp = minHeap.remove();
				minHeap.add(val);
			}
			maxHeap.add(temp);
			maxHeapSize++;
//			System.out.println(maxHeap);
//			System.out.println(maxHeap.peek());
			return maxHeap.peek();
		}

		int temp1;
		int temp2;
	
		if (minHeapSize < maxHeapSize) {
			temp1 = maxHeap.remove();
			maxHeapSize --;
			if (minHeapSize == 0) {
				temp2 = val;
			} else {
				if (val <= minHeap.peek()) {
					temp2 = val;
				} else {
					temp2 = minHeap.remove();
					minHeap.add(val);
				}
				
			}
		} else {
			temp2 = minHeap.remove();
			minHeapSize --;
			if (maxHeapSize == 0) {
				temp1 = val;
			} else {
				if (val >= maxHeap.peek()) {
					temp1 = val;
				} else {
					temp1 = maxHeap.remove();
					maxHeap.add(val);
				}
				
			}
		}
		if (temp1 <= temp2) {
			maxHeap.add(temp1);
			minHeap.add(temp2);
		} else {
			maxHeap.add(temp2);
			minHeap.add(temp1);
		}
		minHeapSize ++;
		maxHeapSize ++;
		return (float)(temp1 + temp2)/ 2;
	}

	public void solve(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			System.out.println(findMedian(arr[i]));
//			System.out.println(maxHeap);
//			System.out.println(minHeap);
		}
	}

	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		Median m = new Median();
		m.solve(arr);
	}
}
























