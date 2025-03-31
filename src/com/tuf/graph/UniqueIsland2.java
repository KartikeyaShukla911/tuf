package com.tuf.graph;

import java.util.HashSet;

public class UniqueIsland2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {
		        {1, 1, 0, 1, 1},
		        {1, 0, 0, 0, 0},
		        {0, 0, 0, 0, 1},
		        {1, 1, 0, 1, 1}};

		System.out.println("Unique island: "+findUnique(grid));
	}
	
	public static int findUnique(int[][] grid)
	{
		int n= grid.length,m=grid[0].length;
		if(n==0 && m==0)
			return 0;
		if(n==1 && m==1)
			return 1;
		
		int[][] visited= new int[n][m];
		HashSet<String> hs = new HashSet();
		
		int i,j;
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				if(grid[i][j]==1 && visited[i][j]==0)
				{
					dfsUtil(grid,i,j,n,m,hs,visited,i,j);
				}
			}
		}
		return hs.size();
	}
	
	public static void dfsUtil(int[][] grid,int rowX,int colY, int n,int m,HashSet<String> hs,int[][] visited,int row0,int col0)
	{
		if(rowX<0 || colY<0 || rowX>=n || colY>=m)
			return;
		if(visited[rowX][colY]==1)
			return;
		
		if(grid[rowX][colY]==0)
			return;
		
		visited[rowX][colY]=1;
		int row =rowX-row0;
		int col = colY-col0;
		hs.add(toString(row,col));

		
		dfsUtil(grid,rowX+1,colY,n,m,hs,visited,row0,col0);
		dfsUtil(grid,rowX-1,colY,n,m,hs,visited,row0,col0);
		dfsUtil(grid,rowX,colY+1,n,m,hs,visited,row0,col0);
		dfsUtil(grid,rowX,colY-1,n,m,hs,visited,row0,col0);
		
	}
	
	/*
	 * * O N x M + log(n x m for hashset  to store all ele ) + nxmx 4 for each sides traversing
	 * S - N x M vis + N x M  call stack - N x M
	 */
	 */
	public static String toString(int a,int b) {
		
		return (a+","+b);
	}
}
