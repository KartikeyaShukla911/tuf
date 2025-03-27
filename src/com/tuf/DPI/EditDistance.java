package com.tuf.DPI;

public class EditDistance {
	
	/*
	 * convert one string to another
	 * Time Complexity: O(N*M)

Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

Space Complexity: O(N*M) + O(N+M)

Reason: We are using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
	 */
	
	public static int minDistance(String s1,String s2, int[][] dp,int i,int j)
	{
		if(i<0)
			return j+1;
		if(j<0)
			return i+1;
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		if(s1.charAt(i)==s2.charAt(j))
		{
			dp[i][j] = minDistance(s1,s2,dp,i-1,j-1);
		}
		else
		{
			dp[i][j]= 1 + Math.min(minDistance(s1,s2,dp,i-1,j-1), Math.min(minDistance(s1,s2,dp,i-1,j), minDistance(s1,s2,dp,i,j-1)));
		}
		return dp[i][j];
	}
	
	static int editDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // Create a 2D array to store the minimum edit distances
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and column with their respective indices
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    // If the characters match, no edit is needed, so take the value from the diagonal.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in S1 with the character in S2 (diagonal).
                    // 2. Delete the character in S1 (left).
                    // 3. Insert the character from S2 into S1 (up).
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
	/*
	 * Time Complexity: O(N*M)

Reason: There are two nested loops

Space Complexity: O(N*M)

Reason: We are using an external array of size ‘N*M’. Stack Space is eliminated.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
