package com.tuf.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {
	
	public static int divide(int[] arr,int low,int high)
	{
		int cnt=0;
		if(low>high)
			return cnt;
		while(low<=high)
		{
			int mid = low+high>>1;
			cnt +=divide(arr,low,mid);
			cnt +=divide(arr,mid,high);
			cnt +=merge(arr,low,mid,high);
		}
		return cnt;
	}
	
	public static int mergeIt(int[] arr,int low,int mid,int high)
	{
		int cnt=0;
		int left = low;
		int right=mid+1;
		
		while(left<=mid && right<=high)
		{
			if(arr[left]<arr[right])
			{
				temp.add(arr[left]);
				left++;
				mid++;
			}
			else
			{
				cnt += (mid-left)+1;
				temp.add(arr[right]);
				right++;
			}
		}
	}
	
	public static int merge(int[] arr,int low,int mid,int high)
	{
		int left = low, right = mid+1;
		List<Integer> arrlist = new ArrayList();
		int cnt=0;
		while(left<=mid && right < high)
		{
			if(arr[left] <arr[right])
			{
				arrlist.add(arr[left]);
				left++;
				mid++;
			}
			else
			{
				arrlist.add(right);
				cnt += mid-left+1;
				right++;
			}
		}
		
		while(left<=mid)
		{
			arrlist.add(arr[left++]);
		}
		
		while(right<high)
		{
			arrlist.add(arr[right]);
		}
		
		int i=0;
		for(int x : arrlist)
		{
			arr[i++]=x;
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
