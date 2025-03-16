package com.tuf.graph;

import java.util.HashSet;

public class NumberOfUniqueIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {
		        {1, 1, 0, 1, 1},
		        {1, 0, 0, 0, 0},
		        {0, 0, 0, 0, 1},
		        {1, 1, 0, 1, 1}};

		System.out.println("Unique island: "+findUnique(grid));
	}

	/*
	 * basically to find Unique island
	 * we need to create a baseline index, and iterate all nearby island size
	 * convert that to string and use hashset to find the unique island
	 * the hs size tell the unique island
	 * 
	 * make a dfs call, a visited and 4 side traverse
	 * O N x M + log(n x m for hashset  to store all ele ) + nxmx 4 for each sides traversing
	 * S - N x M vis + N x M  call stack - N x M
	 */
	public static int findUnique(int[][] grid)
	{
		int n = grid.length;
		int m = grid[0].length;
		
		int i,j;
		
		int[][] vis = new int[n][m];
		
		HashSet<String> hs = new HashSet();
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				if(grid[i][j]==1 && vis[i][j]==0)
				{
					dfs(grid,i,j,hs,i,j,n,m,vis);
				}
			}
		}
		return hs.size();
	}
	
	public static void dfs(int[][] grid,int i,int j, HashSet<String> hs,int row0,int col0,int n,int m,int[][] vis)
	{
		int rowX = i - row0;
		int colY = j-col0;
		
		hs.add(toString(rowX,colY));
		
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		
		vis[i][j]=1;
		for(int x =0;x<4;x++)
		{
			int deltaX = dx[x]+ i;
			int deltaY = dy[x]+i;
			
			if(deltaX>=0 && deltaY>=0 && deltaX<n && deltaY<m && vis[deltaX][deltaY]==0 && grid[deltaX][deltaY]==1)
			{
				dfs(grid,deltaX,deltaY,hs,row0,col0,n,m,vis);
			}
		}
	}
	
	public static String toString(int x,int y)
	{
		return String.valueOf(x)+":"+String.valueOf(y);
	}
}
