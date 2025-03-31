package com.tuf.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BipartiteGraphUsingBfs {

	public static boolean isBipartite(Map<Integer, List<Integer>> graph) {
        int numNodes = graph.size();
        int[] colors = new int[numNodes]; // 0: uncolored, 1: color 1, -1: color 2
        Arrays.fill(colors, 0);

        for (int startNode : graph.keySet()) {
            if (colors[startNode] == 0) {
                if (!bfs(graph, startNode, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(Map<Integer, List<Integer>> graph, int startNode, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        colors[startNode] = 1; // Assign initial color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = -colors[node]; // Assign opposite color
                        queue.offer(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        return false; // Conflict: neighbor has the same color
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 3));
        graph1.put(1, Arrays.asList(0, 2));
        graph1.put(2, Arrays.asList(1, 3));
        graph1.put(3, Arrays.asList(0, 2));

        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1, 2, 3));
        graph2.put(1, Arrays.asList(0, 2));
        graph2.put(2, Arrays.asList(0, 1, 3));
        graph2.put(3, Arrays.asList(0, 2));

        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(0, Arrays.asList(1, 2));
        graph3.put(1, Arrays.asList(0, 2));
        graph3.put(2, Arrays.asList(0, 1));
        graph3.put(3, Arrays.asList(4, 5));
        graph3.put(4, Arrays.asList(3, 5));
        graph3.put(5, Arrays.asList(3, 4));

        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(0, Arrays.asList(1, 3));
        graph4.put(1, Arrays.asList(0, 2));
        graph4.put(2, Arrays.asList(1));
        graph4.put(3, Arrays.asList(0));

        Map<Integer, List<Integer>> graph5 = new HashMap<>();
        graph5.put(0, Arrays.asList(1));
        graph5.put(1, Arrays.asList(0, 2));
        graph5.put(2, Arrays.asList(1, 3));
        graph5.put(3, Arrays.asList(2));

        Map<Integer, List<Integer>> graph6 = new HashMap<>();
        graph6.put(0, new ArrayList<>());

        System.out.println("Graph 1 is bipartite: " + isBipartite(graph1)); // Output: false
        System.out.println("Graph 2 is bipartite: " + isBipartite(graph2)); // Output: false
        System.out.println("Graph 3 is bipartite: " + isBipartite(graph3)); // Output: true
        System.out.println("Graph 4 is bipartite: " + isBipartite(graph4)); // Output: true
        System.out.println("Graph 5 is bipartite: " + isBipartite(graph5)); // Output: true
        System.out.println("Graph 6 is bipartite: " + isBipartite(graph6)); // Output: true
    }
}
