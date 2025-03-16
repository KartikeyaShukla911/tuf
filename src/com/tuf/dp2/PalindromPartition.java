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

}
