package com.tuf.dp2;

public class PalindromPartition {
	
	/*
	 * minCuts needed for Palindrom Partition
	 */
	public static int minPartition(String s, int idx, int n)
	{
		if(idx>=n)
			return 0;
		
		if(palindrome(s,idx,n)==false)
			return 0;
		
		int min = Integer.MIN_VALUE;
		int i,k;
		for(k=idx;k<n;k++)
		{
			min = 1 + Math.min(minPartition(s,idx,k), minPartition(s,k+1,n));
		}
		
		return min;
	}
	
	public static int dpf(String s, int idx, int n, int[][] dp)
	{
		if(idx>=n)
			return 0;
		
		if(palindrome(s,idx,n)==false)
			return 0;
		
		if(dp[idx][n]!=-1)
			return dp[idx][n];
		
		int ans = Integer.MAX_VALUE;
		for(int k=idx;k<n;k++)
		{
			ans = 1 + Math.min(dpf(s,k,n,dp), dpf(s,k+1,n,dp));
		}
		
		return dp[idx][n] = ans;
	}
	
	public static boolean palindrome(String s,int i,int j)
	{
		while(i<=j) {
			if(s.charAt(i++)!=s.charAt(j++))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) 
                return false;
            i++;
            j--;
        }
        return true;
    }

    // Recursive function to find the minimum number of 
  	// cuts needed for palindrome partitioning
    static int palPartitionRec(String s, int i, int j, int[][] memo) {
      
        // check in memo for previously computed results
        if (memo[i][j] != -1) 
            return memo[i][j];

        // Base case: If the substring is empty or 
      	// a palindrome, no cuts needed
        if (i >= j || isPalindrome(s, i, j)) 
            return memo[i][j] = 0;

        int res = Integer.MAX_VALUE, cuts;

        // Iterate through all possible partitions and
      	// find the minimum cuts needed
        for (int k = i; k < j; k++) {
            cuts = 1 + palPartitionRec(s, i, k, memo) 
              		 + palPartitionRec(s, k + 1, j, memo);
            res = Math.min(res, cuts);
        }

        return memo[i][j] = res;
    }

    static int palPartition(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        
        // Initialize memo array with -1
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
        return palPartitionRec(s, 0, n - 1, memo);
    }
    /*
     * O n3, S 29
     */

    
    
    static void generatePal(String s, boolean[][] isPalin) {
        int n = s.length();

        // Substring s[i .. i] of len 1 
        // is always palindromic
        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
        }

        // Iterate over different lengths of substrings
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {

                // Check whether s[i] == s[j] and the
                // substring between them is a palindrome
                if (s.charAt(i) == s.charAt(j) && 
                    (len == 2 || isPalin[i + 1][j - 1])) {

                    // Mark the substring from i to j as a
                    // palindrome
                    isPalin[i][j] = true;
                }
            }
        }
    }
    
    /*
     * O n2, s2
     */
}
