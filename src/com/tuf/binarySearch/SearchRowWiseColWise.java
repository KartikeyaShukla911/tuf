package com.tuf.binarySearch;

public class SearchRowWiseColWise {
	
	/*
	 * search in row wise, col wise matrix
	 * log nxm
	 */
	public static int rowWiseColWise(int[][] mat,int tar)
	{
		int n=mat.length, m = mat[0].length;
		int i,j;
		int row=0, col=m-1;
		while(row<n && col >=0)
		{
			if(mat[row][col]==tar)
				return 1;
			else if(mat[row][col]>tar)
				row--;
			else
				col++;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
