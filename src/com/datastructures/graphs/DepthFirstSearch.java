package com.datastructures.graphs;

import com.datastructures.stacks.impl.ArrayStack;

/**
 * Depth First Search
 * Time Complexity:  O(V + E) [since it traverses every vertex and edge once]
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 4);
        System.out.println(dfsTraversal(graph, 0));
    }

    private static String dfsTraversal(Graph graph, int sourceVertex) {
        String result = "";
        int totalVertices = graph.vertices;
        ArrayStack stack = new ArrayStack(totalVertices);
        boolean[] vertexTracker = new boolean[totalVertices];
        vertexTracker[sourceVertex] = true;
        stack.push(sourceVertex);
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            result = result.concat(String.valueOf(currentNode));
            DLLNode dllNode = null;
            if (graph.adjacencyList[currentNode] != null) {
                dllNode = graph.adjacencyList[currentNode].head;
            }
            while (dllNode != null) {
                if (!vertexTracker[dllNode.data]) {
                    stack.push(dllNode.data);
                    vertexTracker[currentNode] = true;
                }
                dllNode = dllNode.next;
            }
        }
        return result;
    }

}
