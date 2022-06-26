package com.interview.doordash.oa;

import java.util.*;

public class AllShortestPaths {

    static class Node {
        int id;
        int cost;
        public Node(int node, int cost) {
            this.id = node;
            this.cost = cost;
        }
    }
    static class Road {
        int src;
        int dest;

        public Road(int s, int d) {
            this.src = s;
            this.dest = d;
        }

        @Override
        public boolean equals(Object o) {
            Road other = (Road) o;
            return (other != null)
                    && (this.src == other.src && this.dest == other.dest)
                    || (this.src == other.dest && this.dest == other.src);
        }

        @Override
        public int hashCode() {
            int result=17;
            result = 31 * result*this.src;
            result = 31 * result*this.dest;
            return result;
        }

        @Override
        public String toString() {
            return "Road{" +
                    "src=" + src +
                    ", dest=" + dest +
                    '}';
        }
    }


    private static String[] getAllShortestPaths(int[][] routes, int S, int D, int N) {
        //Queue to maintain the distance from the current city/node
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> (n1.cost - n2.cost));
        minHeap.add(new Node(S, 0));

        //1 - based nodes
        N = N + 1;
        int[][] graph = new int[N][N];

        //populate the graph with distance between nodes/cities
        for(int[] route : routes) {
            graph[route[0]][route[1]] = route[2];
            graph[route[1]][route[0]] = route[2];
        }

        // Need to compute the minDistance from source to all other indices
        // Defaulting to max value for now
        int[] minDistance = new int[N];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[S] = 0;

        // The parents array maintains a list of parents who are part of the shortest way to reach the current node from the S
        // For ex: (1,2,3), (2,3,1), (1,3,4), (4,3,5) and S = 1. The parents[3] = {1,2} as we can reach node 3 with minDistance of 4 from S
        List<Integer>[] parents = new List[N];

        while(!minHeap.isEmpty()) {
            Node curNode = minHeap.remove();
            for(int src = curNode.id, dest = 1; dest < N; dest++) {
                if(graph[src][dest] == 0) {
                    continue;
                }
                //compute the cost reaching to dest from source
                int newCost = graph[src][dest] + curNode.cost;
                Node nextNode = new Node(dest, newCost);
                //if cost is cheaper than existing distance
                // 1. add to queue
                // 2. update the distance
                // 3. Add the node to the parent list
                if(minDistance[dest] > newCost) {
                    minDistance[dest] = newCost;
                    minHeap.add(nextNode);
                    parents[dest] = new ArrayList<>(Arrays.asList(src));
                // if dist is similar to minimum, just add the node to the parent list
                } else if(minDistance[dest] == newCost) {
                    parents[dest].add(src);
                }
            }
        }

        //Build all the roads which can lead to destination with minimum distance
        Set<Road> roads = new HashSet<>();
        backtrack(parents, D, roads);


        System.out.println(Arrays.deepToString(parents));
        System.out.println(roads);

        //Check all the roads which gives shortest path to dest against the input list
        // Since its bidirectional road, we need to override the equals function for road and also hashcode
        String[] result = new String[routes.length];
        for(int i=0; i<routes.length; i++) {
            if(roads.contains(new Road(routes[i][0], routes[i][1]))) {
                result[i] = "YES";
            } else {
                result[i] = "NO";
            }
        }

        return result;
    }


    private static void backtrack(List<Integer>[] parents, int curNode, Set<Road> roads) {
        if(parents[curNode] == null || parents[curNode].size() == 0) {
            return;
        }

        for(int parent : parents[curNode]) {
            roads.add(new Road(parent, curNode));
            backtrack(parents, parent, roads);
        }
    }

    public static void main(String[] args) {
        int[][] routes = new int[][] {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {4, 5, 1}, {5, 1, 3}, {1, 3, 2}, {5, 3, 1}};
        String[] paths = getAllShortestPaths(routes, 1, 5, 5);
        System.out.println(Arrays.toString(paths));
    }
}


