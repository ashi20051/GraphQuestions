package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
05th March 2024 - BFS Graph Algorithm (https://learn.innoskrit.in/graph/breadth-first-search/)

Problem Statement:
You are given a set of edges, n, and src,
where edges represents the connection between two nodes,n represents the number of nodes, and src represents the source node.
Traverse the entire graph in a breadth-first fashion.

Example:
Input:
edges = [[0, 1], [0, 2], [1, 2], [1, 3], [1, 4], [2, 5], [3, 4], [3, 5]]
n = 6
src = 0

Output:
0 1 2 3 4 5

 */
public class BFS_GraphAlgo {

    private static List<List<Integer>> buildGraph(int[][] edges, int n) {  // O(V+E)

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    /**
     *
     *
     *         pseudocode :
     *            graph = buildGraph(edges,n)
     *
     *            queue = Queue()
     *            visited = BooleanArray(n)
     *            bfsAns = IntegerArray(n)
     *
     *            Step 1 -
     *            queue.add(src)
     *            visited[src] = true
     *            index = 0
     *
     *            Step - 2 to n
     *            while queue is not empty :
     *                 cur = queue.pop()
     *                 bfsAns[index++] = cur
     *
     *                 //traverse the neighbours of cur
     *                 for nbr in graph[cur] :
     *
     *                     if visited[nbr] is not true :
     *                         queue.add(nbr)
     *                         visited[nbr] = true
     *
     *             return bfsAns
     *
     * @param edges
     * @param n
     * @param src
     * @return
     */

    private static int[] bfs(int[][] edges, int n, int src) {
        List<List<Integer>> graph = buildGraph(edges, n);  // -- O(V+E)

        Queue<Integer> queue = new LinkedList<>();
        int[] bfsAns = new int[n];
        boolean[] visited = new boolean[n];

        queue.add(src);
        visited[src] = true;
        int index = 0;

        bfsAns[index] = src;

        while(!queue.isEmpty()) {    // -- O(V)
            int cur = queue.poll();
            visited[cur] = true;
            bfsAns[index++] = cur;

            for(int nbr: graph.get(cur)) {
                //traverse the neighbours of cur
                if(!visited[nbr]) {
                    queue.add(nbr);
                    visited[nbr] = true;
                }
            }
        }

        return bfsAns;
    }

    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {2, 5}, {3, 4}, {3, 5}};
        int n = 6;
        int src = 0;

        int[] bfsAns = bfs(edges, n, src);

        System.out.print("BFS Traversal of the given graph is: ");
        for(int i=0; i<n; i++) {
            System.out.print(bfsAns[i] + " ");
        }

    }

/*
        Time Complexity: O(V+E)
        Space Complexity: O(V+E) -- space is contributed by Adjacency List.

--------------------------------------------------------------------------------
09th March 2024
        HOW TO TRAVERSE ON MATRIX IN GRAPH?   https://learn.innoskrit.in/graph/how-to-traverse-matrix-in-graph/
--------------------------------------------------------------------------------
While solving problems on the Breadth First Search technique, you will find so many problems on a matrix where you would need to apply the BFS or DFS technique.
Therefore, it's important to understand how we can traverse on matrix.

Let's recall what do we need to apply BFS on a Graph using Adjacency List.

Queue: to get the next element to be processed and for which we need to traverse its neighbors.
Visited: an array, so that we don't visit cells again if they are visited once.
That's it.
💡
In the case of a matrix, we may or may not need a visited array. The reason is simple. Suppose if, we visit a cell that contains 1 as a value.
Therefore, we can change its value to some other value let's say 2. By doing this, we will come to know whether a cell is already visited or not.
And hence, we might not require a separate visited array.

Now, the important thing is how to get the neighbors of any cell.

How to get neighbors?
Let's suppose we are in any (x, y) cell and we want to get neighbors of this cell. Then the neighbor cells would be top, right, bottom, and left.

The neighbors are not always valid cells. How? Look at the right matrix below.
The top cell is invalid. We cannot try to access this. Therefore, we need to make sure that we need to reach only valid cells otherwise, we will get Out of bound error.


directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]

Pseudocode
bfsOnMatrix(int[][] matrix) {
    rows = matrix.length
    cols = matrix[0].length

    queue = Queue()
    queue.add([0, 0]);
    // matrix[0][0] = 1000, assign any integer so that we can know whether it's visited or not.

    while(!queue.isEmpty()) {
        x, y = queue.pop()
        for(direction in directions) {
            newX = x + direction[0]
            newY = y + direction[1]
            if(isValidCell(newX, newY, rows, cols)) {
                queue.add([newX, newY]);
                // matrix[newX][newY] = 1000, assign any integer so that we can know whether it's visited or not.
            }
        }
    }
}


How to check for valid cells?
boolean isValidCell(int x, int y, int rows, int cols) {
    return (x >= 0 && x < rows && y >= 0 && y < cols);
}

 */
}
