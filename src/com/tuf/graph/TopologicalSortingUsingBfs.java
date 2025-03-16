package com.tuf.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingUsingBfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * happens to directed graph only
		 * to tell if the graph has cycle or not
		 * 1 - count indegree,
		 * 2- add the 0 indegree to q
		 * process the result add it
		 * iterate over adj list and reduce indegree[], which have 0 add it
		 * 
		 * is result size != V, there is a cycle
		 */
		
		int v =6;
		
		List<List<Integer>> adj  = new ArrayList();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList());
		}
		 adj.get(5).add(2);
	        adj.get(5).add(0);
	        adj.get(4).add(0);
	        adj.get(4).add(1);
	        adj.get(2).add(3);
	        adj.get(3).add(1);

	        System.out.println("Topological Sort (BFS): " + topologicalSort(v, adj));
		
	}
	
	/*
	 * O V + E
	 * S - 2N
	 */
	public static List<Integer> topologicalSort(int v,List<List<Integer>> adj )
	{
		int indegree[] = new int[v];
		int i;
		for(i=0;i<v;i++)
		{
			for(int neigh : adj.get(i))
			{
				indegree[neigh]++;
			}
		}
		
		Queue<Integer> q = new LinkedList();
		List<Integer> ans = new ArrayList();
		for(i=0;i<v;i++)
		{
			if(indegree[i]==0)
				q.add(i);
		}
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			ans.add(temp);
			for(int x : adj.get(temp))
			{
				indegree[x]--;
				if(indegree[x]==0)
					q.add(x);
			}
		}
		
		if(ans.size()!=v)
			System.out.println("cycle exist");
		
		return ans;
		
	}
	
	// O V + E
}
