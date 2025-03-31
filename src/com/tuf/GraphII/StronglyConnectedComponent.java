package com.tuf.GraphII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponent {
	
	public static int scc(List<List<Integer>> adjList,int v)
	{
		if(v==0)
			return 0;
		Stack<Integer> st = new Stack();
		int[] visited = new int[v];
		
		int i;
		for(i=0;i<v;i++)
		{
			if(visited[i]==0)
			{
				dfs(adjList,v,visited,i,st);
			}
		}
		
		List<List<Integer>> adjT = new ArrayList();
		for(i=0;i<v;i++)
		{
			adjT.add(new ArrayList());
		}
		
		// reversing the graph
		for(i=0;i<v;i++)
		{
			visited[i]=0;
			for(int itr : adjList.get(i))
			{
				adjT.get(itr).add(i);
			}
		}
		
		int scc=0;
		//use stack and do dfs to count the connected noes;
		while(!st.isEmpty())
		{
			int node = st.peek();
			st.pop();
			if(visited[node]==0)
			{
				scc++;
				dfs3(node,visited,adjT);
			}
		}
		return scc;
	}
	
	public static void dfs3(int node,int[] visited,List<List<Integer>> adjT)
	{
		visited[node]=1;
		for(int itr : adjT.get(node))
		{
			if(visited[itr]==0)
				dfs3(itr,visited,adjT);
		}
	}
	
	public static void dfs(List<List<Integer>> adj,int v,int[] visited,int idx,Stack<Integer> st)
	{
		visited[idx]=1;
		for(int itr : adj.get(idx))
		{
			if(visited[itr]==0)
			{
				dfs(adj,v,visited,itr,st);
			}
		}
		st.push(idx);
	}

	/*
	 * O(V+E + V+E + V+E = dfs, reversing then dfs
	 * S = 2 V for visited, 1 V for stack 1 for recursive fn = 4V 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> adjList = new ArrayList();
		
	}

}
