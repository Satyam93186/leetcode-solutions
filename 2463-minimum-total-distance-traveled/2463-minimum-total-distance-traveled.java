import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size(), m = factory.length;
        long[][] dp = new long[n + 1][m + 1];

        for(int i = 0; i <= n; i++) Arrays.fill(dp[i], (long)1e18);
        for(int j = 0; j <= m; j++) dp[0][j] = 0;

        for(int j = 1; j <= m; j++){
            int p = factory[j - 1][0], lim = factory[j - 1][1];

            for(int i = 0; i <= n; i++){
                dp[i][j] = dp[i][j - 1];

                long d = 0;
                for(int k = 1; k <= lim && i - k >= 0; k++){
                    d += Math.abs(robot.get(i - k) - p);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + d);
                }
            }
        }

        return dp[n][m];
    }
}