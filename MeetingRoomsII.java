package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
	
	
	private static int meetingRooms(int[][] intervals) {
		
		Arrays.sort(intervals,new Comparator<int[]>() {
				public int compare(int[] i1,int[] i2) {
					return Integer.compare(i1[0], i2[0]);
				}
		});
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int cnt=0;
		
		for(int[] interval:intervals) {
			
			
			if(q.isEmpty()) {
				cnt++;
				q.offer(interval[1]);
			}
			else {
				
				if(interval[0]>=q.peek())
					q.poll();
				else
					cnt++;
				q.offer(interval[1]);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] intervals = new int[][] {{0,30},{5,10},{1,3},{9,20},{25,30},{10,14}};
		int min = meetingRooms(intervals);
		System.out.println(min);

	}

}
