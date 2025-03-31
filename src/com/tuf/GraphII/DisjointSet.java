package com.tuf.GraphII;

public class DisjointSet {

	    int[] parent, rank;

	    public DisjointSet(int n) {
	        parent = new int[n];
	        rank = new int[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i; // Initially, each element is its own leader
	            rank[i] = 0; // Rank (tree height) starts at 0
	        }
	    }

	    // Find with path compression
	    public int find(int v) {
	        if (parent[v] != v) {
	            parent[v] = find(parent[v]); // Path compression
	        }
	        return parent[v];
	    }

	    // Union by rank
	    public void union(int v1, int v2) {
	        int root1 = find(v1);
	        int root2 = find(v2);

	        if (root1 != root2) {
	            if (rank[root1] > rank[root2]) {
	                parent[root2] = root1; // Attach root2 to root1
	            } else if (rank[root1] < rank[root2]) {
	                parent[root1] = root2; // Attach root1 to root2
	            } else {
	                parent[root2] = root1;
	                rank[root1]++;
	            }
	        }
	    }
	}
/*
 * Time Complexity
Operation	Complexity
Find	
𝑂
(
𝛼
(
𝑛
)
)
O(α(n)) (almost constant due to path compression)
Union	
𝑂
(
𝛼
(
𝑛
)
)
O(α(n)) (almost constant due to rank)
𝑂
(
𝛼
(
𝑛
)
)
O(α(n)) is inverse Ackermann function, which is practically constant (≈ O(1)) for real-world inputs.

Conclusion
Disjoint Set is an efficient data structure for merging and finding sets.

Used in Kruskal’s Algorithm, graph connectivity, and network problems.

Path Compression & Union by Rank optimize performance.
