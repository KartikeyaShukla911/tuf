package com.tuf.graph;

import java.util.List;

public class DetectCycleInGraphUsingDFS {
	
	public static boolean findCycle(List<List<Integer>> adj,int v)
	{
		if(v==0)
			return false;
		
		int[] parent=new int[v];
		int[] visited = new int[v];
		
		if(dfs(adj,v,0,parent,visited)==true)
		{
			return true;
		}
		return false;
	}
	
	public static boolean dfs(List<List<Integer>> adj,int v,int idx,int parent[],int visited[])
	{
		visited[idx]=1;
		parent[idx]=1;
		for(int edge : adj.get(idx))
		{
			if(visited[edge]==0)
			{
				if(dfs(adj,v,edge,parent,visited)==true)
					return true;
			}
			else
			{
				if(parent[edge]==1)
					return true;
			}
		}
		return false;
	}
	/*
	 * Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.

Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N) for recursive stack space.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
