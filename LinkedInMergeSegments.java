package leetcode;

import java.util.*;

public class LinkedInMergeSegments {

    TreeMap<Integer, Integer> intervals = new TreeMap<>();

    /**
     * Adds the new interval to the list of intervals and merges the new list if possible
     */
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if(start != null && intervals.get(start) >= left){
            left = start;
        }
        if(end != null && intervals.get(end) > right){
            right = intervals.get(end);
        }
        intervals.put(left, right);

        intervals.subMap(left, false, right, true).clear();

        System.out.println(intervals);
    }

    /**
     * Computes the sum of the difference between the each disjoint interval in the lnterval list
     */
    int getTotalIntervalCoverage(){
        int size = 0;
        for(int key : intervals.keySet()){
            size+= intervals.get(key) - key;
        }

        return size;
    }

    public static void main(String[] args) {
    	LinkedInMergeSegments task = new LinkedInMergeSegments();

        task.addRange(1,5);
        task.addRange(4,6);

        System.out.println(task.getTotalIntervalCoverage()); //5

        task.addRange(10,20);
        task.addRange(25,30);

        System.out.println(task.getTotalIntervalCoverage()); //20

        task.addRange(19,29);

        System.out.println(task.getTotalIntervalCoverage()); //25


    }

}
