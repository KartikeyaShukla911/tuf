package com.tuf.recursion;

import java.util.Arrays;
import java.util.Comparator;

class Job
{
	int start;
	int end;
	int profit;
	
	public Job(int start,int end,int profit)
	{
		this.start=start;
		this.end=end;
		this.profit=profit;
	}
}

class jobComparator implements Comparator<Job>
{
	@Override
	public int compare(Job a,Job b)
	{
		return b.profit-a.profit;
	}
}

public class JobSequencing {
	
	
	
	public int[] JobScheduling(Job[] arr,int n)
	{
		int ans[] = new int[2];
		Arrays.sort(arr,new jobComparator());
		int max=0;
		int i;
		for(i=0;i<n;i++)
		{
			max=Math.max(max, arr[i].end);
		}
		
		int res[] = new int[max+1];
		Arrays.fill(res, -1);
		
		int maxProfit=0,j;
		int cntJob=0;
		for(i=0;i<n;i++)
		{
			for(j=arr[i].end;j>0;j--)
			{
				if(res[j]==-1)
				{
					res[j]=i;
					maxProfit+=arr[i].profit;
					cntJob++;
					break;
				}
			}
		}
		
		ans[0]=cntJob;
		ans[1]=maxProfit;
		
		return ans;
		/*
		 * O n log n + n*m
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Job[] arr = new Job[4];
	      arr[0] = new Job(1, 4, 20);
	      arr[1] = new Job(2, 1, 10);
	      arr[2] = new Job(3, 1, 40);
	      arr[3] = new Job(4, 1, 30);

	      JobSequencing ob = new JobSequencing();

	      //function call
	      int[] res = ob.JobScheduling(arr, 4);
	      System.out.println(res[0] + " " + res[1]);
	}
}
