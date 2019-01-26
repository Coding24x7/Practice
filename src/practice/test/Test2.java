package practice.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

class TestSet {
    protected int V1; 
    
    // constructor  
    TestSet(int V1) 
    { 
        this.V1 = V1; 
          
    } 
	
}

public class Test2 {

	class Graph 
    { 
        private int V; 
          
        // constructor  
        Graph(int V) 
        { 
            this.V = V; 
              
        } 
    } 
      
    // Adds an edge to an undirected graph 
    void addEdge(int src, int dest) 
    { 
    	Graph graph = new Graph(src);
        // Add an edge from src to dest.  
        System.out.println("adfdfd " + graph.V);
        TestSet ts = new TestSet(src);
        System.out.println("testset " + ts.V1);
    } 
    
    class Scomp implements Comparator<Graph> {
    	public int compare(Graph g1, Graph g2) {
    		return 0;
    	}
    }
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.addEdge(100, 0);
		String s = "lll";
		List l = new LinkedList<Integer>();
		Map<String, Integer> m = new HashMap();
		Float f = new Float(1);

		for(Entry<String, Integer> e : m) {
			parseInt
			parseFloat
			parseDouble
			paresLong
			toString
			valueOf
		}
		Set s1 = new HashSet<Integer>();
		s1 = new TreeSet<Integer>();
		s1 = new LinkedHashSet<Integer>();
		Stack st = new Stack<String>();
		st.peek();
		st.push(1);
		st.remove("a");
		Queue q = new LinkedList<String>();
		q.poll();
		q.peek();
		q.add("s");
		Deque dq = new LinkedList<String>();
		dq.add("q");
		dq.addFirst("w");
		dq.addLast(e);
		dq.poll(); // pollFirst, pollLast
		dq.peek(); // peekFirst, peekLast
		
		Queue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
	}
}
