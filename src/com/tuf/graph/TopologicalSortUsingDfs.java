package com.tuf.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortUsingDfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> adj = new ArrayList();
		int v = 6;
		
		for(int i =0;i<v;i++)
			adj.add(new ArrayList());
		
		 adj.get(5).add(2);
	        adj.get(5).add(0);
	        adj.get(4).add(0);
	        adj.get(4).add(1);
	        adj.get(2).add(3);
	        adj.get(3).add(1);

	        System.out.println("Topological Sort (DFS): " + topologicalSortDfs(v, adj));
	}

	/*
	 * O V+E
	 */
	/*
	 * only in direct graph
	 * take a stack, and visited,
	 * call helper and add the result,
	 * stack contains the ans.
	 * 
	 * once process all the adj neigbour, add that node to the stack
	 */
	public static List<Integer> topologicalSortDfs(int v,List<List<Integer>> adj)
	{
		int vis[] = new int[v];
		Stack<Integer> st = new Stack();
		int i;
		
		for(i=0;i<v;i++)
		{
			if(vis[i]==0)
				dfs(i,adj,vis,st);
		}
		return new ArrayList<>(st);
	}
	
	public static void dfs(int idx,List<List<Integer>> adj, int vis[],Stack<Integer> st)
	{
		if(vis[idx]==1)
			return;
		vis[idx]=1;
		for(int temp : adj.get(idx))
		{
			if(vis[temp]==0)
				dfs(temp,adj,vis,st);
		}
		st.add(idx);
	}
}
