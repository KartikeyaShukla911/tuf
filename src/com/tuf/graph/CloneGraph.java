package com.tuf.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph
{
	int v;
	List<Graph> adjList;
	
	public Graph(int v)
	{
		this.v = v;
		adjList= new ArrayList();
	}
}

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph node1 = new Graph(1);
		Graph node2 = new Graph(2);
		Graph node3 = new Graph(3);
		Graph node4 = new Graph(4);
		List<Graph> adj = new ArrayList();
		adj.add(node1);
		adj.add(node2);
		node1.adjList = adj;
		adj = new ArrayList();
		adj.add(node4);
		node4.adjList = adj;
		
		cloneGraph(node1);
	}
	
	public static Graph cloneGraph(Graph node)
	{
		if(node==null)
			return null;
		
		Queue<Graph> q = new LinkedList();
		HashMap<Graph,Graph> hm = new HashMap();
		
		Graph clone = new Graph(node.v);
		hm.put(node, clone);
		
		q.add(node);
		while(!q.isEmpty())
		{
			Graph temp = q.poll();
			
			for(Graph neighbor : temp.adjList)
			{
				if(!hm.containsKey(neighbor))
				{
					q.add(neighbor);
					hm.put(neighbor, new Graph(neighbor.v));
				}
				hm.get(temp).adjList.add(hm.get(neighbor));
			}
		}
		return clone;
	}
	
	public static void buildGraph()
	{
		
	}

}
