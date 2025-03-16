package com.tuf.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> adj = new ArrayList();
		int i,v=4;
		
		for(i=0;i<v;i++)
		{
			adj.add(new ArrayList());
		}
		
		adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
		
		if(bipartite(adj,v,0))
			System.out.println("yes");
		else
			System.out.println("No");
	}
	
	public static boolean bipartite(List<List<Integer>> adj, int v,int color)
	{
		int[] colour = new int[v];
		Arrays.fill(colour, -1);
		
		int i;
		
		for(i=0;i<v;i++)
		{
			if(colour[i]==-1)
			{
				if(dfs(adj,v,i,color,colour)==false)
					return false;
			}
		}
		return true;
	}
	
	/*
	 * O V+2E
	 * S - 3V
	 */
	public static boolean dfs(List<List<Integer>> adj,int v,int idx,int color,int[] colour)
	{
		
		colour[idx]=color;
		for(int x : adj.get(idx))
		{
			if(colour[x]==-1)
			{
				if(dfs(adj,x,idx,1-color,colour)==false)
					return false;
			}
			else
			{
				if(colour[x]==color)
					return false;
			}
		}
		return true;
	}
	
	/*
	 * to color a graph with 2 colors,
	 * use a dfs approach
	 * in each, pass the color 0 with iteration and check for next color
	 * do dfs, if color[-1] == same to next color, it's not possible
	 */
	
}

/*
 * O V+2E
 * S - 3V
 */

