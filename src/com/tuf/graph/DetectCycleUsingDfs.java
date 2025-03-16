package com.tuf.graph;

import java.util.ArrayList;

public class DetectCycleUsingDfs {

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
        
        if(dfs(adj,4))
        	System.out.println("yes cycle");
	}
	
	public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int v)
	{
		int[] vis = new int[v];
		int i;
		for(i=0;i<v;i++)
		{
			if(vis[i]==0)
			{
				if(dfsUtil(adj,i,vis,-1)==true)
					return true;
			}
		}
		return false;
	}
	
	public static boolean dfsUtil(ArrayList<ArrayList<Integer>> adj, int idx,int[] vis,int parent)
	{
		vis[idx]=1;
		for(int x : adj.get(idx))
		{
			if(vis[idx]==0)
			{
				dfsUtil(adj,x,vis,parent);
			}
			else
			{
				if(idx!=parent)
					return true;
			}
		}
		return false;
	}

	// O N + 2E
}
