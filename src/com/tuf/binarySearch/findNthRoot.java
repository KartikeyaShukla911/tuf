package com.tuf.binarySearch;

public class findNthRoot {
	
	/*
	 * brute
	 * basicall, generate all N pow number and check if it's equal to the M
	 * if not or greater, return -1
	 * else return the answer
	 * 
	 * TC- O M = where M is the number
	 * S - 1,
	 */
	
	public static int NthRoot(int n, int m) {
        // Use binary search on the answer space:
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }
    
    public static int func(int mid,int b, int exp) {
        long  ans = 1;
        long base = b;
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans = ans * base;
            } else {
                exp /= 2;
                base = base * base;
            }
        }
        if(ans==mid)
        	return 1;
        if(ans>mid)
        	return 2;
        return 0;
    }
    	/*
    	 * log N
    	 */
}
