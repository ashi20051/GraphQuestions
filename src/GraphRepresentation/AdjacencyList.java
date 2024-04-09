package GraphRepresentation;

import java.util.ArrayList;
import java.util.List;

/*
27th Feb 2024:
Problem : Given a list of edges and number of nodes n. Create an adjacency list to represent the Graph.
Input:
    edges = [[0, 1], [0, 2], [1, 2], [1, 3], [1, 4], [2, 5], [3, 4], [3, 5]]
    n = 6
Output:
    0 : 1 2
    1 : 0 2 3 4
    2 : 0 1 5
    3 : 1 4 5
    4 : 1 3
    5 : 2 3
 */
public class AdjacencyList {
    protected List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();

        //adding arrays of list to the graph list -- i.e number of nodes
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {          // number of edges times
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {2, 5}, {3, 4}, {3, 5}};
        int n = 6;

//        List<List<Integer>> graph = new ArrayList<>();
//
//        // adding arrays of list to the graph list -- i.e number of nodes
//        for (int i=0; i<n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        //                                   0      1     2    ...
//        // edge[0] = [0,1]       graph = [ [1,2], [0,2,3,4] [0,1,5]  .... ]
//        // edge[1] = [0,2]
//        // edge[2] = [1,2]
//
//        for (int[] edge : edges) {          // number of edges times
//            graph.get(edge[0]).add(edge[1]);
//            graph.get(edge[1]).add(edge[0]);
//        }
//
//        //print the adjacency list
//        for (int i=0; i<n; i++ ) {
//            System.out.print(i + " : ");
//            for (int nbr : graph.get(i)) {
//                System.out.print(nbr + " ");
//            }
//            System.out.println();
//        }

        // Simplifying code by adding methods
        AdjacencyList adjacencyList = new AdjacencyList();
        List<List<Integer>> graph = adjacencyList.buildGraph(edges, n);

        //print list
        for (int i=0; i<n; i++ ) {
            System.out.print(i + " : ");
            for (int nbr : graph.get(i)) {
                System.out.print(nbr + " ");
            }
            System.out.println();
        }

        /*
        Time Complexity : O(V+E) -- V is no.of vertices, E is no.of edges
                          Worst case: each node is connected with every other node i.e Complete Graph
                                    V is no.of vertices, Number of edges = V(V-1)/2
                                    complexity = O(V + V(V-1)/2) = O(V + V^2) = O(V^2)

         Space Complexity : O(V+E)
        */
    }
}

