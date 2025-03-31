package com.tuf.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleBfsGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        
        
        
        if(bfsCycle(adj,4))
        {
        	System.out.println("yes cycle ");
        }
	}
	
	public static boolean bfsCycle(ArrayList<ArrayList<Integer>> adj,int v)
	{
		boolean vis[] = new boolean[4];
        int[] parent = new int[4];
        Arrays.fill(vis, false);
        Arrays.fill(parent, -1);
        
        for(int i =0;i<v;i++)
        {
        	if(vis[i]==false)
        	{
        		if(checkCycle(adj,i,vis,parent))
        			return true;
        	}
        }
        return false;
	}
	
	/*
	 * Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.

Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and visited array.
	 */
	
	public static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int idx, boolean[] vis,int[] parent)
	{
		vis[idx]=true;
		Queue<Node> q = new LinkedList();
		q.add(new Node(idx,-1)); // source parent
		
		while(!q.isEmpty())
		{
			int node = q.peek().first;
			int par = q.peek().second;
			q.remove();
			
			for(int itr : adj.get(node))
			{
				if(vis[itr]==false)
				{
					q.add(new Node(itr,node));
				}
				
				else if(itr!=par)
					return true;
			}
		}
		return false;
	}
	
	public static boolean isCycleBfs(List<List<Integer>> adj,int v)
	{
		boolean vis[] = new boolean[v];
		int parent[] = new int[v];
		
		Arrays.fill(vis, false);
		Arrays.fill(parent, -1);
		
		for(int x=0;x<v;x++)
		{
			if(vis[x]==false)
			{
				if(isCycle(x,v,adj,vis,parent))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isCycle(int idx,int v,List<List<Integer>> adj,boolean[] vis,int parent[])
	{
		Queue<Pair> q = new LinkedList();
		q.add(new Pair(idx,-1));
		vis[idx]=true;
		while(!q.isEmpty())
		{
			int f = q.peek().first;
			int s = q.peek().second; // parent
			q.poll();
			
			for(int x : adj.get(s))
			{
				if(vis[x]==false)
				{
					return isCycle(x,v,adj,vis,parent);
				}
				else
				{
					if(x!=s)
						return true;
				}
			}
		}
		return false;
	}
	/*
	 * O V+E
	 * O V 
	 */
}
class Node
{
	int first;
	int second;
	
	public Node(int first,int second)
	{
		this.first=first;
		this.second=second;
	}
}

class Pair
{
	int first;
	int second;
	
	public Pair(int first,int second)
	{
		this.first=first;
		this.second=second;
	}
}
