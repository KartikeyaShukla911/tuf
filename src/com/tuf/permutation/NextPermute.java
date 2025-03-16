package com.tuf.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,3,2,5,7,};
		ArrayList<Integer> ans = new ArrayList<Integer>(arr.length);
		System.out.println("Next Permute: "+nextPer(ans));
	}

	public static List<Integer> nextPer(List<Integer> arr)
	{
		int n = arr.size();
		
		
		int i,idx,j;
		idx=n-2;
		while(idx>=0)
		{
			if(arr.get(idx)<arr.get(idx+1))
			{
				break;
			}
			else
				idx--;
		}
		
		if(idx<=0)
		{
			
			Collections.reverse(arr);
			return arr;
		}
		
		for(i=n-1;i>=idx;i--)
		{
			if(arr.get(i)>arr.get(idx))
			{
				Collections.swap(arr, i, idx);
				break;
			}
		}
		
		reverse(arr,idx+1,n-1);
		return new ArrayList(arr);
	}
	
	public static void reverse(List<Integer> arr,int i,int j)
	{
		while(i<j)
		{
			Collections.swap(arr, i, j);
			i++;j--;
		}
	}
}
