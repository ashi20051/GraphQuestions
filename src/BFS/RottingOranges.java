package BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
09th March 2024 : Rotting Oranges https://learn.innoskrit.in/graph/rotten-oranges/

Problem Statement
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Leetcode link: https://leetcode.com/problems/rotting-oranges/description/

 */
class Node {
    int row, col, time;
    public Node(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}



public class RottingOranges {
    static int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) {
        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int minTime = solution(grid);

        System.out.println(minTime);
    }

    public static int solution(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Node> queue = new LinkedList<>();   // Space = worst case when all cells of matrix have rotten oranges, then we have to store all cells
                                                  //        hence, O(m*n)
        int freshOranges = 0;

        //iterate matrix to find src i.e rotten oranges positions
        for(int i=0; i<rows; i++) {                             // ---------- Time = O(m*n)
            for(int j=0; j<cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Node(i,j,0));
                }
//                else if (grid[i][j] == 1) {
//                    freshOranges +=1;
//                }
            }
        }

        //now iterate the neighbours of src added in the queue and repeat the process until queue is empty
        int minTime = 0;
        while(!queue.isEmpty()) {

            Node curNode = queue.poll();
            //iterate the neighbours of the curr node
            for( int[] direction : directions) {
                int xNbr = curNode.row + direction[0];
                int yNbr = curNode.col + direction[1];

                if (isValid(xNbr,yNbr, rows, cols) && grid[xNbr][yNbr] == 1) {
                    queue.add(new Node(xNbr,yNbr,curNode.time+1));
                    grid[xNbr][yNbr] = 2;
                    minTime = curNode.time+1;
//                    freshOranges -=1;

//                    System.out.println(minTime + " ");
                }
            }
        }

        for (int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }


        return minTime;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        if(row >= 0 && row < rows && col >= 0 && col < cols)
            return true;
        else
            return false;
    }

}
