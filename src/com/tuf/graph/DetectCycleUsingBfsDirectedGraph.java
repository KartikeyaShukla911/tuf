package com.tuf.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUsingBfsDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int v = 5;
		List<List<Integer>> adjList=new ArrayList();
		int i;
		for(i=0;i<v;i++)
		{
			adjList.add(new ArrayList());
		}
		adjList.get(0).add(3);
		adjList.get(2).add(4);
		
		System.out.println("Check cycle in direccted"+checkCycle(adjList,v));
	}

	public static boolean checkCycle(List<List<Integer>> adjList, int v)
	{
		if(v==0)
			return false;
		
		int[] indegree= new int[v];
		int i;
		for(i=0;i<v;i++)
		{
			for(int edge : adjList.get(i))
			{
				indegree[edge]++;
			}
		}
		
		Queue<Integer> q = new LinkedList();
		for(i=0;i<v;i++)
		{
			if(indegree[i]==0)
			{
				q.add(i);
			}
				
		}
		
		int cnt=0;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			cnt++;
			
			for(int edge : adjList.get(temp))
			{
				indegree[edge]--;
				if(indegree[edge]==0)
					q.add(edge);
			}
		}
		
		if(cnt==v)
			return true;
		return false;
	}
	/*
	 * Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the in-degree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).
	 */
}
