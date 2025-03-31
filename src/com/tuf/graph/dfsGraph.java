package com.tuf.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class dfsGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> adjList = new ArrayList();
		
		for(int i=1;i<=5;i++)
		{
			adjList.add(new ArrayList());
		}
		
		adjList.get(1).add(3);
		adjList.get(2).add(1);
		
		boolean[] vis = new boolean[5];
		dfs(1,vis,adjList);
		vis = new boolean[5];
		bfs(1,vis,adjList);
	}

	public static void dfs(int v,boolean[] vis,List<List<Integer>> adj)
	{
		vis[v]=true;
		System.out.println(v);
		
		for(int itr : adj.get(v))
		{
			if(vis[itr]==false)
			{
				dfs(itr,vis,adj);
			}
		}
	}
	
	public static void bfs(int v,boolean vis[],List<List<Integer>> adj)
	{
		Queue<Integer> q = new LinkedList();
		q.add(v);
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			System.out.println(temp);
			vis[temp]=true;
			
			for(int itr : adj.get(temp))
			{
				if(vis[itr]==false)
				{
					q.add(itr);
					vis[itr]=true;
				}
			}
		}
	}
	/*
	 * dfs
	 * Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are calling the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.
	 
	 * bfs
	 * Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
	 */
}
