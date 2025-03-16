package com.tuf.arrays;

public class MinInRotatedArray {

	/*
	 * 
	 * we check if low<=high, if true in a loop, search for the min element and break, since it's sorted
	 * if not, then in else, check if it's min is in low and min and update low = mid+1
	 * else check in mid to high, and update high = mid-1;
	 */
	public static int minRotatedArr(int[] arr,int low,int high)
	{
		int n = arr.length;
		int min=Integer.MAX_VALUE;
		while(low<=high && low<n)
		{
			int mid = (high+low)>>1;
			if(arr[low]<=arr[high])
			{
				min = Math.min(arr[low], min);
				break; // imp
			}
			else
			{
				if(arr[low]<=arr[mid])
				{
					min = Math.min(arr[low], min);
					low = mid+1;
				}
				else
				{
					min = Math.min(min, arr[mid]);
					high = mid-1;
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {3,4,5,1,2};
		System.out.println("min in rotated arr: "+minRotatedArr(arr,0,arr.length-1));
	}

}
