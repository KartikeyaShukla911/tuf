package com.tuf.String;

public class LongestPalindromeString {
	
	/*
	 * brute, create all substrings and for each check palindrome, t's size and store the ans;
	 *  O N x N x N/2
	 */
	public static void checkPalin1(String ans)
	{
		int n,i,j;
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				String temp = ans.substring(i,j);
				if(isPalin(temp)==true)
				{
					ans = Math.max(ans, j-i+1);
				}
			}
		}
		return ans;
		
	}
	
	public static boolean isPalin(String s)
	{
		int i;
		for(i=0;i<n/2;i++)
		{
			if(s.charAt(i)!=s.charAt(n-1-i));
				return false;
		}
		return true;
	}
	
	/*
	 * this dp approach, takes O N^2, S^2;
	 */
	public static void checkPalin2(String s)
	{
		int i,j;
		boolean[][] dp = new boolean[n][n];
		
		for(i=0;i<n;i++)
		{
			dp[i][i]==true;
		}
		
		for(i=0;i<n-1;i++)
		{
			dp[i][i+1]=true;
		}
		
		int len;
		for(len=3;len<=n;len++)
		{
			for(i=0;i<n-len;i++)
			{
				int j = len+i-1;
				
				if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true)
				{
					dp[i][j]=true;
					start=i;
					max = len;
				}
			}
		}
		return s.subSequence(start, max+len);
	}
	
	/*
	 * O - N using Manacher's Algo
	 * Basically, create a radius circle P - with center start and end,
	 * use the property of Palindrome and expand with the count maintaining indexes
	 */
	
	public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform the string
        StringBuilder transformed = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            transformed.append("#").append(c);
        }
        transformed.append("#$");
        char[] T = transformed.toString().toCharArray();
        int n = T.length;
        
        // Step 2: Manacher's Algorithm
        int[] P = new int[n];  // Stores palindrome radius
        int C = 0, R = 0;  // Center and Right boundary
        int maxLen = 0, centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            // Mirror index
            int mirror = 2 * C - i;

            // Step 3: Use previously computed palindrome info
            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Step 4: Expand around center
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) {
                P[i]++;
            }

            // Step 5: Update Center and Right Boundary
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

            // Step 6: Keep track of the longest palindrome found
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Step 7: Extract the longest palindromic substring
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
