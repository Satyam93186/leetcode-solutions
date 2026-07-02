import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(best[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0) {
            return false;
        }

        queue.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int currHealth = current[2];

            if (row == m - 1 && col == n - 1) {
                return true;
            }

            for (int k = 0; k < 4; k++) {

                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {

                    int newHealth = currHealth - grid.get(newRow).get(newCol);

                    if (newHealth > 0 && newHealth > best[newRow][newCol]) {

                        best[newRow][newCol] = newHealth;
                        queue.offer(new int[]{newRow, newCol, newHealth});
                    }
                }
            }
        }

        return false;
    }
}