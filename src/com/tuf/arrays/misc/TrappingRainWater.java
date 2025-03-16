package com.tuf.arrays.misc;

public class TrappingRainWater {

	
	public static int trappingWater(int arr[])
	{
		int n = arr.length;
		int lrr[] = new int[n];
		int rrr[] = new int[n];
		
		int i;
		lrr[0] = arr[0];
		rrr[n-1]=arr[n-1];
		
		for(i=1;i<n;i++)
		{
			lrr[i]=Math.max(arr[i], lrr[i-1]);
		}
		
		for(i=n-2;i>=0;i--)
		{
			rrr[i]=Math.max(rrr[i+1], arr[i]);
		}
		
		int ans=0;
		for(i=0;i<n;i++)
		{
			ans += Math.abs(Math.min(lrr[i], rrr[i]) - arr[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
