package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


// Reference  : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
//  Leetcode  : 373
public class LinkedInKSmallestProductsofTwoSortedArray {
	
	private class Pair{
        int x;
        int y;
        int sum = 0;
        
        public Pair(){
            
        }
        
        public Pair(int x,int y,int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
        
        public List<Integer> getPairs(PriorityQueue<Pair> pq,int k){
        	List<Integer> ans  = new ArrayList<>();
            
            int p = 0;
            
            while(p<k && !pq.isEmpty()){
                List<Integer> lst = new ArrayList<>();
                Pair val = pq.poll();
                ans.add(val.sum);
                p++;
            }
            
            return ans;
        }
        
    }
	
	public  List<Integer> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.sum - b.sum);
        if(nums1.length == 0)
            return new ArrayList<>();
        if(nums2.length == 0)
            return new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                Pair pair = new Pair(nums1[i],nums2[j],nums1[i]*nums2[j]);
                pq.add(pair);
            }
        }
        
        Pair p = new Pair();
        return p.getPairs(pq,k);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedInKSmallestProductsofTwoSortedArray object = new LinkedInKSmallestProductsofTwoSortedArray();
		int[] num1= new int[] {-2, -1, 0, 1, 2};
		int[] num2= new int[] {-3, -1, 2, 4, 5};
		int k = 3;
		
		List<Integer> res = object.kSmallestPairs(num1,num2,k);
		System.out.print(res);

	}

}
