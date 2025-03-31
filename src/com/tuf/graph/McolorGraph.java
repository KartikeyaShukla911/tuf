package com.tuf.graph;

public class McolorGraph {
	
	import java.util.*;

	class MColoring {

	    public static int[] mColoring(Map<Integer, List<Integer>> graph, int m) {
	        int numNodes = graph.size();
	        int[] coloring = new int[numNodes];
	        Arrays.fill(coloring, 0); // 0 means no color

	        if (solve(graph, m, coloring, 0)) {
	            return coloring;
	        } else {
	            return null; // No solution found
	        }
	    }

	    private static boolean solve(Map<Integer, List<Integer>> graph, int m, int[] coloring, int node) {
	        if (node == coloring.length) {
	            return true; // All nodes colored successfully
	        }

	        for (int color = 1; color <= m; color++) {
	            if (isSafe(graph, node, color, coloring)) {
	                coloring[node] = color;
	                if (solve(graph, m, coloring, node + 1)) {
	                    return true; // Recursive call successful
	                }
	                coloring[node] = 0; // Backtrack
	            }
	        }
	        return false; // No color works for this node
	    }

	    private static boolean isSafe(Map<Integer, List<Integer>> graph, int node, int color, int[] coloring) {
	        if (!graph.containsKey(node)) {
	            return true; // Node has no neighbors
	        }
	        for (int neighbor : graph.get(node)) {
	            if (coloring[neighbor] == color) {
	                return false; // Neighbor has the same color
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        Map<Integer, List<Integer>> graph1 = new HashMap<>();
	        graph1.put(0, Arrays.asList(1, 2, 3));
	        graph1.put(1, Arrays.asList(0, 2));
	        graph1.put(2, Arrays.asList(0, 1, 3));
	        graph1.put(3, Arrays.asList(0, 2));

	        Map<Integer, List<Integer>> graph2 = new HashMap<>();
	        graph2.put(0, Arrays.asList(1, 2));
	        graph2.put(1, Arrays.asList(0, 2, 3));
	        graph2.put(2, Arrays.asList(0, 1, 3));
	        graph2.put(3, Arrays.asList(1, 2));

	        Map<Integer, List<Integer>> graph3 = new HashMap<>();
	        graph3.put(0, Arrays.asList(1, 2));
	        graph3.put(1, Arrays.asList(0, 2));
	        graph3.put(2, Arrays.asList(0, 1));
	        graph3.put(3, Arrays.asList(4, 5));
	        graph3.put(4, Arrays.asList(3, 5));
	        graph3.put(5, Arrays.asList(3, 4));

	        int m1 = 3;
	        int m2 = 2;
	        int m3 = 3;

	        int[] result1 = mColoring(graph1, m1);
	        int[] result2 = mColoring(graph2, m2);
	        int[] result3 = mColoring(graph3, m3);

	        System.out.println("Graph 1 with " + m1 + " colors: " + Arrays.toString(result1));
	        System.out.println("Graph 2 with " + m2 + " colors: " + Arrays.toString(result2));
	        System.out.println("Graph 3 with " + m3 + " colors: " + Arrays.toString(result3));
	    }
	}
	/*
	 *  O(m^n)

Space Complexity:

coloring array:
This array stores the color of each node and takes O(n) space.
Recursion Stack:
The solve function is recursive.
In the worst case, the recursion depth can be n.
Therefore, the recursion stack can take O(n) space.
graph map:
The space occupied by the graph map depends on the number of nodes and edges in the graph. In the worst case, if the graph is fully connected, the space complexity of the graph can be O(n^2). However, typically, we consider the graph to be input, so we don't include it in the algorithm's space complexity.
Overall Space Complexity: O(n).
	 */
}
