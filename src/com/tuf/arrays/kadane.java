package com.tuf.arrays;

public class kadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = null;
		System.out.println("kadane"+kadane(arr));
	}
	
	public static int kadane(int[] arr)
	{
		int lo=0,glo=0;
		for(int i=0;i<arr.length;i++)
		{
			lo+=arr[i];
			glo = Math.max(glo, lo);
			lo = lo < 0 ? 0 : lo; 
		}
		return glo;
	}

}
