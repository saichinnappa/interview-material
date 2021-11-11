package com.datastructures.graphs;

import com.datastructures.queues.impl.ArrayQueue;

/**
 * Breadth First Search
 * Time Complexity:  O(V + E) [since it traverses every vertex and edge once]
 */
public class BreadthFirstSearch {

    static String bfsTraversal(Graph graph, int sourceVertex) {
        String result = "";
        int totalVertices = graph.vertices; //get total vertices in the graph
        if (totalVertices < 1)
            return result; //if vertex is only one just return
        boolean[] visitedNodes = new boolean[totalVertices]; //boolean array to keep track of visited nodes
        ArrayQueue queue = new ArrayQueue(totalVertices); //queue to keep track of visited nodes
        queue.enqueue(sourceVertex); //start with source vertex in the queue
        visitedNodes[sourceVertex] = true; //mark source vertex as visited
        while (!queue.isEmpty()) { //loop through until the queue is empty
            int currentNode = queue.dequeue(); //dequeue the queue to process the element
            result = result.concat(String.valueOf(currentNode)); // add the element to the result as a string
            DLLNode currentHeadNode = null;
            if (graph.adjacencyList[currentNode] != null) { //get the DLL for that particular node if not null, get the head
                currentHeadNode = graph.adjacencyList[currentNode].head;
            }
            while (currentHeadNode != null) { //loop through the DLL until it reaches end of the list
                if (!visitedNodes[currentHeadNode.data]) { //for every element in the list, first check if its already visited by checking the boolean array
                    visitedNodes[currentHeadNode.data] = true; //if not visited mark the node as visited
                    queue.enqueue(currentHeadNode.data); //and also add it to queue
                }
                currentHeadNode = currentHeadNode.next; // keep moving to next node
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
//        graph.printGraph();
        System.out.println(bfsTraversal(graph, 1));
    }
}
