package com.tuf.arrays.misc2;

import java.util.HashSet;

public class Twosum {
	
	/*
	 * O-n
	 * S - n
	 */
	
	public static int sum2(int[] arr, int tar)
	{
		HashSet<Integer> hs = new HashSet();
		for(int i=0;i<arr.length;i++)
		{
			if(hs.contains(arr[i]))
				return 1;
			hs.add(Math.abs(tar-arr[i]));
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Two sum prob");
		int i;
		int[] arr= {2,6,5,8,11};
		if(sum2(arr,100)==1)
			System.out.println("Yes");
			
	}

}
