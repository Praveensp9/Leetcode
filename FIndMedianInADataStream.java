package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

//Leetcode 295
public class FIndMedianInADataStream {
	
	PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>(){
		public int compare(Integer a,Integer b) {
			return b.compareTo(a);
		}
	});
	
	public void addNum(int num) {
		max.offer(num);
		min.offer(max.peek());
		max.poll();
		if(max.size() < min.size()) {
			max.offer(min.peek());
			min.poll();
		}
	}
	
	public double findMedian() {
		
		if(max.size() == min.size()) {
			 	double a = max.peek();
	            double b = min.peek();
	            double med = (a+b)/2.0;
	            
	            return med;
		}
		else {
				return max.peek();
		}
	}
	
	public static void main(String[] args) {

	}

}
