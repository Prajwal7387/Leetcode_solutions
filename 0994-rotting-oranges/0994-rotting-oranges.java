import java.util.*;

class Solution {

    static class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Cell> queue = new LinkedList<>();
        int fresh = 0;

        // Find fresh and rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    fresh++;
                } 
                else if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j));
                }
            }
        }

        int time = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Cell current = queue.poll();

                for (int k = 0; k < 4; k++) {

                    int newRow = current.row + dr[k];
                    int newCol = current.col + dc[k];

                    if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        queue.add(new Cell(newRow, newCol));
                    }
                }
            }

            time++;
        }

        // If fresh oranges remain, impossible
        if (fresh > 0) {
            return -1;
        }

        return time;
    }
}