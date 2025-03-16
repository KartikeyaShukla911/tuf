package com.tuf.arrays;

public class StockBuySell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,1,5,3,6,4};

	    int maxPro = maxProfit(arr);
	    System.out.println("Max profit is: " + maxPro);
	}

	public static int maxProfit(int[] arr)
	{
		int n = arr.length;
		
		int i;
		int mini=Integer.MAX_VALUE;
		int MAXI=Integer.MIN_VALUE;
		
		for(i=0;i<n;i++)
		{
			mini = Math.min(mini,arr[i]);
			MAXI=Math.max(MAXI, arr[i]-mini);
		}
		return MAXI;
	}
}
