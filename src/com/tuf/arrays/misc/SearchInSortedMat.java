package com.tuf.arrays.misc;

public class SearchInSortedMat {
	
	public static int searchMatrix(int[][] arr,int n,int m,int tar)
	{
		int low=0,high = n*m;
		while(low<high)
		{
			int mid = low+high>>1;
			int row = mid%n;
			int col = mid / m;
			
			if(arr[row][col]==tar)
			{
				return 1;
			}
			
			else if (arr[row][col]>tar)
			{
				high = mid-1;
			}
			else
				low = mid+1;
			
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
