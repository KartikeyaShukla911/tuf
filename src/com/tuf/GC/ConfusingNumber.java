package com.tuf.GC;

import java.util.Map;

public class ConfusingNumber {
	    private static final Map<Integer, Integer> rotateMap = Map.of(
	        0, 0, 1, 1, 6, 9, 8, 8, 9, 6
	    );
	    private int count = 0;

	    public int confusingNumberCount(int n) {
	        dfs(0, n);
	        return count;
	    }

	    private void dfs(long num, int n) {
	        if (num > n) return; // Stop if number exceeds n
	        if (isConfusing(num)) count++;

	        for (int digit : rotateMap.keySet()) {
	            if (num == 0 && digit == 0) continue; // Avoid leading zero
	            long newNum = num * 10 + digit;
	            dfs(newNum, n);
	        }
	    }

	    private boolean isConfusing(long num) {
	        long original = num, rotated = 0;
	        while (num > 0) {
	            int digit = (int) (num % 10);
	            rotated = rotated * 10 + rotateMap.get(digit);
	            num /= 10;
	        }
	        return rotated != original;
	    }

	    public static void main(String[] args) {
	        ConfusingNumber cn = new ConfusingNumber();
	        System.out.println(cn.confusingNumberCount(20)); // Output: 6
	        System.out.println(cn.confusingNumberCount(100)); // Output: 19
	    }
	    
	    /*
	     * Time Complexity
DFS explores all possible numbers → 
𝑂
(
log
⁡
𝑁
)
O(logN)

Checking rotation is 
𝑂
(
log
⁡
𝑁
)
O(logN).

Overall Complexity: 
𝑂
(
log
⁡
2
𝑁
)
O(log 
2
 N), which is efficient.
	     */
	}
