package com.tuf.arrays.misc2;

import java.util.Arrays;

public class Foursum {
	
	public static int FourSum(int[] arr,int tar)
	{
		Arrays.sort(arr);
		int n =arr.length;
		int left=0,right=-1;
		int i,j;
		int cnt=0;
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				left=j+1;
				right=n-1;
				while(left<right)
				{
					int x = arr[i]+arr[j]+arr[left]+arr[right];
					if(x==tar)
					{
						cnt++;
						left++;
						right--;
					}
					else if(x<tar)
						left++;
					else
						right--;
				}
			}
		}
	}
	/*
	 * N3 = skipping duplicates
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
