/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
        int T = in.nextInt();
        
        while (T -- > 0) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) nums[i] = in.nextInt();
            System.out.println(firstMissingPositive(nums));
        }
	}
	
	public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;

    	// Rearange the array
    	int last = nums.length - 1;
    	int start = 0;
    	for (;start <= last; ++start){
    		if (nums[start] <= 0) continue;
                    
    		// nums[start] > 0
    		while (last >= 0 && nums[last] > 0) --last;
    
    		// All element > 0
    		if (last < 0) break;
    
    		// nums[last] <= 0 - last always != start
    		if (last < start) break;
    
    		int tmp = nums[last];
    		nums[last] = nums[start];
    		nums[start] = tmp;
    	}
    
            if (start == nums.length) return 1;
                
    	for (int i = 0; i < start; ++i) nums[i] = 1;
    
    	for (int i = start; i < nums.length; ++i){
    		// nums[i] > 0
    		if (Math.abs(nums[i]) - 1 < nums.length) {
    			nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
    		}
    	}
    
    	for (int i = 0; i < nums.length; ++i){
    		if (nums[i] > 0) return i + 1;
    	}
	
        return nums.length + 1;
    }
}
