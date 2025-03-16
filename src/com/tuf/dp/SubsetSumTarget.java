package com.tuf.dp;

import java.util.Arrays;

public class SubsetSumTarget {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        // return true/false
        boolean[][] dp = new boolean[n+1][k+1];
        for(boolean[] row: dp)
        	Arrays.fill(row, false);
        if (subsetSumToK(n, k, arr,dp))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
	}

	
	public static boolean subsetSumToK(int n, int k, int[] arr,boolean[][] dp)
	{
		if(n==0)
		{
			return arr[0] == k;
		}
		
		if(k==0)
			return true;
		
		if(dp[n][k]!=false)
			return true;
		
		boolean notTake = subsetSumToK(n-1,k,arr,dp);
		boolean take = false;
		if(arr[n-1]<=k)
		{
			take = subsetSumToK(n-1,k-arr[n-1],arr,dp);
		}
		
		return dp[n][k] = take || notTake;
		// dp[n][k];
	}
	
	/*
	 * O nxk
	 * Onxk + On
	 */
}
