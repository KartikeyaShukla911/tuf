/**
 * 
 */
package com.tuf.arrays;

import java.util.Arrays;

/**
 * @author ellit
 *
 */
public class MergeTwoSortedArrays {

	/**
	 * @param args
	 */
	
	/*
	Two merge two sorted arrays, take low = n-1 and high = 0
	initally both arrays are sorted, so create a loop, and check both the elements in the arrays
	if lesser, then swap the arrays
	now sort all those array.
	TC - O - n + m + nlogn + mlog m => 
	S = 1
	*/
	public static void mergeTwoArr(int[] arr1,int[] arr2)
	{
		int n = arr1.length;
		int m = arr2.length;
		
		int low=n-1,high=0;
		
		while(low>=0 && high < m)
		{
			if(arr1[low] >arr2[high])
			{
				int tmp = arr1[low];
				arr1[low]=arr2[high];
				arr2[high]=tmp;
				low--;high++;
			}
			else
				break;
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
