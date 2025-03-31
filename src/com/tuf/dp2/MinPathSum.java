package com.tuf.dp2;

public class MinPathSum {

	public static int minPathSum(int[][] arr,int n,int m,int dp[][])
	{
		if(n==0 && m==0)
			return arr[0][0];
		
		if(n==0 || m==0)
			return Integer.MAX_VALUE;
		
		if(dp[n][m]!=-1)
			return dp[n][m];
		
		int up = arr[n][m]+ minPathSum(arr,n-1,m,dp);
		int left = arr[n][m] + minPathSum(arr,n,m-1,dp);
		
		return dp[n][m] = Math.min(up, left);
	}
	
	static int minSumPath(int n, int m, int[][] matrix) {
        int dp[][] = new int[n][m];

        // Iterate through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = matrix[i][j]; // If we're at the top-left cell, the minimum sum is its value
                else {
                    int up = matrix[i][j];
                    if (i > 0)
                        up += dp[i - 1][j]; // Add the value from above if it's not out of bounds
                    else
                        up += (int) Math.pow(10, 9); // Add a large value if out of bounds in the up direction

                    int left = matrix[i][j];
                    if (j > 0)
                        left += dp[i][j - 1]; // Add the value from the left if it's not out of bounds
                    else
                        left += (int) Math.pow(10, 9); // Add a large value if out of bounds in the left direction

                    // Store the minimum of the two possible paths
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        // The final result is stored in the bottom-right cell of the DP matrix
        return dp[n - 1][m - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
