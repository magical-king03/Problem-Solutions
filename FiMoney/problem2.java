package FiMoney;

import java.util.LinkedList;
import java.util.Queue;

// In a m x n grid, 
// 0 - empty space
// 1 - healthy student
// 2 - student affected by flu

// Find the minimum time required to make all students affected by flu, if it is not possible, return -1.

// Input: grid=[[2,1,1],[1,1,0],[0,1,1]]
// Output: 4


public class problem2 {
    public static int minTimeToInfectAll(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int totalHealthy = 0; 
        int time = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0}); 
                } else if (grid[i][j] == 1) {
                    totalHealthy++;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currTime = current[2];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2; 
                    queue.add(new int[]{nx, ny, currTime + 1});
                    totalHealthy--;
                    time = Math.max(time, currTime + 1);
                }
            }
        }

        return totalHealthy > 0 ? -1 : time;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(minTimeToInfectAll(grid)); 
    }
}
