package com.tuf.arrays.misc2;

import java.util.Arrays;

public class Foursum {
	
	public static int FourSum(int[] arr,int tar)
	{
		Arrays.sort(arr);
		int n =arr.length;
		
		int i,j,k,l;
		for(i=0;i<n;i++)
		{
			if(i-1>0 && arr[i]==arr[i-1])
				continue;
			for(j=i+1;j<n;j++)
			{
				if(j-1>0 && arr[j] ==arr[j-1])
					continue;
			}
			
			k=j+1;
			l=n-1;
			
			int temp = arr[i]+arr[j]+arr[k]+arr[l];
			if(temp==tar)
			{
				System.out.println("Yes");
				k++;
				l--;
				while(k<l && arr[k]==arr[k-1]) {
					k++;
					continue;
					
				}
				while(k<l && arr[l]==arr[l-1]) {
					
					l--;
					continue;
				}
			}
			else if(temp<tar)
			{
				k++;
			}
			else
			{
				l--;
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
