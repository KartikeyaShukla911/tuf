package com.tuf.dp;

public class MaxSumIncreasingSubSeq {

	/*
	 * purpose here is to find the max sum of a seq array, such that they are always in increasing order
	 * takke, length n, start from 1 to n-1
	 * call a helper fn, which takes this i index,
	 * from(j=i-1;j>=0;j--)
	 * for each check previous element, check and store the sum + arr[i] + prev fn
	 */
	public static int maxIncSubSeq(int[] arr)
	{
		int maxi = 0;
		int i,n=arr.length;
		for(i=0;i<n;i++)
		{
			maxi = Math.max(maxi, arr[i] + fn(arr,i,n));
		}
		return maxi;
	}
	
	public static int fn(int arr[], int i,int n)
	{
		int ans = arr[i];
		
		for(int j=i-1;j>=0;j--)
		{
			ans = Math.max(ans, arr[j] + fn(arr,j,n));
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
