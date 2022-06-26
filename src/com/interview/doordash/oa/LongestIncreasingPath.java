package com.interview.doordash.oa;

/**
 Given a grid of numbers, find the longest path you can take by walking only on adjacent numbers of the same value.
 You cannot walk on the same number twice in the same path.

 The solution is O(R * C * (4 ^ (R * C)) brute force. Dynamic programming does not work.

 [
 [1, 1, 2, 1],
 [5, 5, 5, 5],
 [5, 5, 5, 1]
 ]

 But below approach exceeds timelimit, as we launch dfs from each node
 Can't do memoization  to reduce timecomplexity
 To do memoization needs a 3D matrix for each value

 **/
public class LongestIncreasingPath {
    int longestPath = 0;
    public static void main(String[] args) {
        LongestIncreasingPath m = new LongestIncreasingPath();

        int[][] grid = {{1, 1, 2, 1},
                {5, 5, 5, 5},
                {5, 5, 5, 1}};

//        int[][] grid = {{1,1}, {5,5}, {5,5}};

        System.out.println(m.longestIncreasingPath(grid) + " => 7");
    }


    int[][] matrix;
    int[][] directions = {{-1,0},{1,0}, {0,1},{0,-1}};
    //int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length<1) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        this.matrix = matrix;
        // this.memo = new int[m][n];

        //for(int i=0; i<m; i++){
        //    for(int j=0; j<n; j++){
        //        memo[i][j] = -1;
        //    }
        //}

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean[][] visited = new boolean[m][n];
                if(!visited[i][j]){
                    dfs(matrix, visited, i, j, matrix[i][j], 0);
                }
            }
        }

        return longestPath;
    }

    public void dfs(int[][] arr, boolean[][] visited, int row, int col, int target, int path) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || visited[row][col] || arr[row][col] != target) {
            longestPath = Math.max(path, longestPath);
            return;
        }

        if (arr[row][col] == target) {
            path++;
        }

        visited[row][col] = true;
        dfs(arr, visited, row + 1, col, target, path);
        dfs(arr, visited, row, col + 1, target, path);
        dfs(arr, visited, row - 1, col, target, path);
        dfs(arr, visited, row, col - 1, target, path);
        visited[row][col] = false;
    }
}