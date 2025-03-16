package com.tuf.dp2;

public class MaxProfitInJobScheduling {
	
		   int[] dp;
		   int ans=0;
		    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		        int n = startTime.lenth;
		        int[][] job = new int[n][3];
		        int i;

		        for(i=0;i<n;i++)
		        {
		            job[i] = new int[]{startTime[i],endTime[i],profit[i]};
		        }

		        // sorting based on start time
		        Arrays.sort(job, (a,b)-> a[0] - b[0]);
		       int[] dp  = new int[n+1];
		       Arrays.fill(dp,-1);
		        return dfs(job,0,n);
		    }

		    public int dfs(int[][] job,int idx,int n)
		    {
		        if(idx==n)
		        {
		            return 0;
		        }

		        if(dp[idx]!=-1)
		            return dp[idx];

		        int findNext = find_Next(job,job[idx][1]);
		        int select = dfs(job,findNext) + job[idx][2]; // adding profit and calling next method
		        int not_select = dfs(job,idx+1);

		        dp[idx] = Math.max(select,not_select);
		        ans = Math.max(ans,dp[idx]);
		        return dp[idx];
		    }

		    public int find_Next(int[][] job, int endTime)
		    {
		        int low =0, high= job.length;
		        while(low<high)
		        {
		            int mid = low+high >> 1;
		            if(job[mid][0] >= t)
		            {
		                high = mid;
		            }
		            else 
		                low = mid+1;
		        }
		        return low;
		    }

		    // O n^2 + n log n + log n
		    // S n + n 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
