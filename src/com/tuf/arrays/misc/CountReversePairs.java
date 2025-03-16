package com.tuf.arrays.misc;

import java.util.ArrayList;
import java.util.List;

public class CountReversePairs {
	
	/*
	 * count reverse pairs
	 * where i < j && arr[i] > 2*arr[j] 
	 */
	public static int countPairs(int arr[])
	{
		int n = arr.length;
		
		int cnt=0;
		int low=0,high=n-1;
		cnt = divide(arr,low,high);
	}
	
	public static int divide(int[] arr,int low,int high)
	{
		int cnt=0;
		while(low<=high)
		{
			int mid = low+high>>1;
			cnt+=divide(arr,low,mid);
			cnt+=divide(arr,mid+1,high);
			cnt+=  condition(arr,low,mid,high);
			merge(arr,low,mid,high);
		}
		return cnt;
	}
	
	
	
	/*
	 * condition t o check arr[i] > arr[j]*2
	 */
	
	public static int condition(int[] arr,int low,int mid,int high)
	{
		int right = mid+1;
		int cnt=0,i;
		for(i=low;i<=mid;i++)
		{
			while(right<=high && arr[i] > arr[right]*2)
				right++;
			cnt += (right-mid+1);
		}
		return cnt;
	}
	
	public static int merge(int[] arr,int low,int mid,int high)
	{
		
	}
	
	public static void merge(int[] arr,int low,int mid,int high)
	{
		int left = low;
		int right = mid+1;
		List<Integer> temp = new ArrayList();
		while(left <=mid && right<=high)
		{
			if(arr[left]<arr[right])
			{
				temp.add(arr[left]);
				left++;
			}
			else {
				temp.add(arr[right]);
				right++;
			}
		}
		
		/*(copy left
		copy right)
		*/
//		int[] ans = temp.stream().mapToInt(Integer::intValue).toArray();
//		temp.stream().mapToInt(Integer::intValue).toArray();
//		temp.stream().mapToInt(Integer::intValue).toArray();
//		temp.stream().mapToInt(Integer::intValue).toArray();
//		temp.stream().mapToInt(Integer::intValue).toArray();
//		temp.steram().mapToInte(Integer::intValue).toArray();
//		temp.stream().mapToInt(Integer::intValue).toArray();
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
