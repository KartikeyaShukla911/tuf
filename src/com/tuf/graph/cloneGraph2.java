package com.tuf.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cloneGraph2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5);
		Graph node2 = new Graph(2);
		Graph node1 = new Graph(1);
		Graph node3 = new Graph(3);
		
		List<Graph> adj = new ArrayList();
		adj.add(node1);
		adj.add(node2);
		node3.adjList = adj;
		
		Graph clone = null;
		cloneGraph(clone,node3);
	}
	
	public void cloneGraph(Graph clone, Graph node)
	{
		if(node==null)
			return ;
		
		HashMap<Graph,Graph> mp = new HashMap();
		clone = new Graph(node.v);
		Queue<Graph> q = new LinkedList();
		mp.put(node,clone);
		
		q.add(node);
		while(!q.isEmpty())
		{
			Graph temp = q.poll();
			
			
			for(Graph y : temp.adjList)
			{
				if(mp.containsKey(y))
				{
					q.add(y);
					mp.put(y, new Graph(y.v));
				}
				mp.get(temp).adjList.add(mp.get(y));
			}
		}
	}

}

class graph
{
	int v;
	List<Integer> neigh;
	
	public graph(int v)
	{
		this.v = v;
		this.neigh = new ArrayList();
	}
}
