package com.tuf.dp;

public class LCS {
	
	public static int lcsRec(char[] c1,char[] c2,int n,int m)
	{
		if(n<=0 || m<=0)
			return 0;
		
		if(c1[n-1]==c2[m-1])
		{
			return 1 + lcsRec(c1,c2,n,m);
		}
		else
			
			return Math.max(lcsRec(c1,c2,n-1,m),lcsRec(c1,c2,n,m-1));
	}
	
	public static int lcs(char[] c1,char[] c2,int n,int m)
	{
		int dp[][] = new int[n+1][m+1];
		
		int i,j;
		for(i=0;i<n;i++)
		{
			dp[i][0]=1;
			dp[0][i]=1;
		}
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				if(c1[i]==c2[j])
				{
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
