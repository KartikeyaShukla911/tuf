package com.tuf.arrays.misc;

public class TrappingRainWater {

	/*
	 * On, S2n
	 */
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
	
	/*
	 * On, S1
	 */
	public static int trap(int[] arr)
	{
		int left=0,right=arr.length-1;
		int ans=0;
		int leftMax=0;
		int rightMax=0;
		while(left<=right)
		{
			if(arr[left]<=arr[right])
			{
				if(arr[left]>=leftMax)
				{
					leftMax = arr[left];
				}
				else
					ans += leftMax - arr[left];
				left++;
			}
			else
			{
				if(arr[right]>=rightMax)
				{
					rightMax = arr[right];
				}
				else
					ans += rightMax - arr[right];
				right--;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The total trapped water is " + trap(arr));
	}

}
