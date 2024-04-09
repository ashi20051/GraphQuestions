package GraphRepresentation;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix {
/*
27th Feb 2024
Problem Statement: Given a 2D matrix grid and number of nodes n. Print an adjacency list from the given grid to represent the Graph.
Example:
Input:
    grid = [[0, 1, 1, 0, 0, 0],
            [1, 0, 1, 1, 1, 0],
            [1, 1, 0, 0, 0, 1],
            [0, 1, 0, 0, 1, 1],
            [0, 1, 0, 1, 0, 0],
            [0, 0, 1, 1, 0, 0]]
    n = 6
Output:
    0 : 1 2
    1 : 0 2 3 4
    2 : 0 1 5
    3 : 1 4 5
    4 : 1 3
    5 : 2 3
*/
    public static void main(String[] args) {
        int[][] grid =  {   {0, 1, 1, 0, 0, 0},
                            {1, 0, 1, 1, 1, 0},
                            {1, 1, 0, 0, 0, 1},
                            {0, 1, 0, 0, 1, 1},
                            {0, 1, 0, 1, 0, 0},
                            {0, 0, 1, 1, 0, 0} };
        int n = 6;

        //Build Graph
        List<List<Integer>> graph = new ArrayList<>();
//        for(int i=0; i<n; i++) {
//            graph.add(new ArrayList<>());
//        }
        //[ [], [], [], [], [], [] ]


        for(int i=0; i<n; i++) {
//            graph.add(new ArrayList<>());
            System.out.print(i + " : ");
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
//                    graph.get(i).add(j);
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
        // [ [1,2], [0,2,3,4], [0,1,5] .... ]

        //Print Graph
//        for (int i=0; i<n; i++ ) {
//            System.out.print(i + " : ");
//            for (int nbr : graph.get(i)) {
//                System.out.print(nbr + " ");
//            }
//            System.out.println();
//        }
    }

    /*
        Time Complexity: O(V*V), because we are iterating the entire matrix of V*V
        Space Complexity: O(1), because except for the input matrix, we are not utilizing any extra space to represent the graph
     */
}
