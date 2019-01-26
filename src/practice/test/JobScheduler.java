package practice.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Job implements Comparable<Job> {
	int id, profit, deadline;
	
	Job(int id, int deadline, int profit) {
		this.id = id;
		this.profit = profit;
		this.deadline = deadline;
	}

	public int compareTo(Job j2) {
		if ( j2.deadline > this.deadline) return 1;
		if (j2.deadline < this.deadline) return -1;
		return j2.profit - this.profit;
	}
}

public class JobScheduler {

	class JobComp implements Comparator<Job> {
		public int compare(Job j1, Job j2) {
			return j2.profit - j1.profit;
		}
	}

	public ArrayList<Integer> findMax(List<Job> jobs) {
		Collections.sort(jobs);
		Job lastJ = null;
		ArrayList<Integer> selected = new ArrayList<Integer>();

		Queue<Job> maxHeap = new PriorityQueue<Job>(jobs.size(), new JobComp());

		for (Job j : jobs) {
			if (lastJ == null) {
				selected.add(j.id);				
			} else {
				if (lastJ.deadline == j.deadline) {
					maxHeap.add(j);
				} else {
					for(int i=1; i< lastJ.deadline - j.deadline; i ++) {
						Job maxJ = maxHeap.poll();
						if (maxJ == null) {
							break;
						}
						selected.add(maxJ.id);
					}
					Job maxJ = maxHeap.poll();
					if(maxJ == null || maxJ.profit < j.profit) {
						selected.add(j.id);
						if (maxJ != null) maxHeap.add(maxJ);
					} else {
						selected.add(maxJ.id);
						maxHeap.add(j);
					}
				}
			}
			lastJ = j;
		}
		if(lastJ != null && lastJ.deadline>1) {
			for(int i=0; i <lastJ.deadline - 1; i++) {
				Job maxJ = maxHeap.poll();
				if (maxJ == null) {
					break;
				}
				selected.add(maxJ.id);
			}
		}
		return selected;
	}

	public static void main(String args[]) 
    { 
        ArrayList<Job> arr=new ArrayList<Job>(); 
        arr.add(new Job(1,3,100)); 
        arr.add(new Job(2,2,19)); 
        arr.add(new Job(3,3,27)); 
        arr.add(new Job(4,2,25)); 
        arr.add(new Job(5,4,15)); 
        System.out.println("Following jobs need to be "+ 
                           "executed for maximum profit");
        JobScheduler sch = new JobScheduler();
        System.out.println(sch.findMax(arr));
    } 

}
