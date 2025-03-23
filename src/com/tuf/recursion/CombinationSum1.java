package com.tuf.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
	
	/*
	 * O 2^n^k
	 * S k*x
	 */
	public static void findComb(int[] arr,int tar,int idx,List<Integer> temp,
			List<List<Integer>> ans,int n)
	{
		if(idx==n)
		{
			if(tar==0)
			{
				ans.add(new ArrayList(temp));
			}
			return;
		}
		
		if(arr[idx]<=tar)
		{
			temp.add(arr[idx]);
			findComb(arr,tar-arr[idx],idx,temp,ans,n);
			temp.remove(temp.size()-1);
		}
		findComb(arr,tar,idx+1,temp,ans,n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,6,7}; 
        int target = 7;
        List < List < Integer >> ls = new ArrayList();
        List<Integer> temp = new ArrayList();
        findComb(arr,target,0,temp,ls,arr.length);
        System.out.println(ls);
	}

}
