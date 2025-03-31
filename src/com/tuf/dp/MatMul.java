package com.tuf.dp;

public class MatMul {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 20, 30, 40, 50};
		
		int n = arr.length;
		
		
		
		System.out.println("The minimum number of operations are "+
	        f(arr,1,n-1));
	}
	
	
	/*
	 * minimum matrix multiplication required to show
	 */
	public static int f(int[] arr,int low,int high)
	{
		if(low==high)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		int k;
		for(k=low;k<=high-1;k++)
		{
			min = Math.min(min, (f(arr,low,k) + f(arr,k+1,high) + arr[low-1]*arr[high]*arr[k]));
		
			dp[low][high] = Math.min(mini,ans);
		}
		return min;
	}

}
