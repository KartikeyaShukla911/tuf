package com.tuf.arrays.misc2;

public class MaxProdArray {
	
	
	public static int maxProdArr(int arr[])
	{
		int n=arr.length;
		int left=1;
		int right=1;
		int i,maxi=1;
		for(i=0;i<n;i++)
		{
			left *= arr[i];
			right *= arr[n-i-1];
			
			maxi = Math.max(maxi,Math.max(left, right));
			
			if(left<0)
				left=1;
			if(right<0)
				right=1;
		}
		return maxi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
