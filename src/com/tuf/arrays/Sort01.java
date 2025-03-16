package com.tuf.arrays;

public class Sort01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,0,2,1,1,0};
		
		System.out.println(sort01(arr));
	}
	
	public static int[] sort01(int[] arr)
	{
		int low=0,mid=0,high=arr.length-1;
		
		while(mid<=high)
		{
			if(arr[low]==0)
			{
				swap(arr,low,mid);
				low++;
				mid++;
			}
			else if(arr[mid]==1)
				mid++;
			else
			{
				swap(arr,mid,high);
				high--;
				mid++;
			}
		}
		return arr;
	}
	
	public static void swap(int arr[],int a,int b)
	{
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	

}
