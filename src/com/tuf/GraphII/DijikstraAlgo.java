package com.tuf.GraphII;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair
{
	int weight;
	int edge;
	
	public Pair(int weight,int edge)
	{
		this.weight=weight;
		this.edge=edge;
	}
}

public class DijikstraAlgo {

	public static int[] findPath(List<List<Pair>> adj,int v,int source)
	{
		int dist[]=new int[v];
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.weight-y.weight);
		
		Arrays.fill(dist, (int)(1e9));
		dist[source]=0;
		pq.add(new Pair(0,source));
		
		while(!pq.isEmpty())
		{
			Pair temp = pq.poll();
			int uWeight = temp.weight;
			int uNode = temp.edge;
			
			for(Pair itr : adj.get(uNode))
			{
				int vWeight = itr.weight;
				int vNode = itr.edge;
				
				if(uWeight+vWeight<dist[vNode])
				{
					dist[vNode]=uWeight+vWeight;
					pq.add(new Pair(dist[vNode],vNode));
				}
			}
		}
		return dist;
	}
	
	// if last node is 1e9, then path didn't found
	
	
	/*
	 * 𝑂
(
(
𝑉
+
𝐸
)
log
⁡
𝑉
)
O((V+E)logV) due to priority queue operations.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
