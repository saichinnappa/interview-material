package com.datastructures.graphs;

public class CycleDetection {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 0);
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 4);
        graph.printGraph();
        System.out.println(detectCycle(graph));
    }

    /**
     * #########  NOT WORKING ###########
     * If a head node of a vertex is already visited then there is a cycle
     */
    static boolean detectCycle(Graph graph) {
        boolean[] vertexTracker = new boolean[graph.vertices];
        //loop through all vertices
        for (int i = 0; i < graph.vertices; i++) {
            //chehck if vertex list is not null
            if (graph.adjacencyList[i] != null) {
                //mark vertex as tracked in two cases
                //1. if head of the list is null
                //2. if head of the list is not null & head node of the list is not visited
                if (graph.adjacencyList[i].head == null || (graph.adjacencyList[i].head != null && !vertexTracker[graph.adjacencyList[i].head.data])) {
                    vertexTracker[i] = true;
                    //else the head node is already visited and there is a loop
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkPath(Graph graph, int source, int destination) {
        int totalVertices = graph.vertices;
        if (graph.adjacencyList[source] != null) {
            DLLNode currentNode = graph.adjacencyList[source].head;
            if (currentNode != null) {
                if (currentNode.data == destination) {
                    return true;
                }

            }
        }

        return false;
    }


}
