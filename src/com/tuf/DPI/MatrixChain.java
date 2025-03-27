package com.tuf.DPI;

public class MatrixChain {
	
	public static int mcm(int[] arr,int i,int j)
	{
		if(i>=j)
			return 0;
		
		int min = Integer.MIN_VALUE;
		int k;
		for(k=i;k<=j-1;k++)
		{
			int ans = mcm(arr,i,k) + mcm(arr,k+1,j)  + arr[i-1] * arr[j]* arr[k];
			min = Math.min(ans, min);
		}
		return min;
	}
	
	/*
	 * O N 3, and O n2 // recursion stack
	 */
	
	public static int mcmDp(int[] arr,int i,int j,int[][] dp)
	{
		if(i==j)
			return 0;
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		int k,min=Integer.MIN_VALUE;
		for(k=i;k<j-1;k++)
		{
			int ans = mcmDp(arr,i,k,dp) + mcmDp(arr,k+1,j,dp) + arr[i-1]*arr[j]*arr[k];
			dp[i][j] = Math.min(ans,dp[i][j]);
		}
		return dp[i][j];
	}
	
	/*
	 * O N 3, S N2
	 */
	public static int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n]; // DP table

        // Fill DP table for chains of length 2 to n-1
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try different partitions
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
