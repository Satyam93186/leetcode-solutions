class Solution {
    public int maximumAmount(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][][] dp = new int[m][n][3];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) dp[i][j][k] = Integer.MIN_VALUE;
            }
        }
        
        dp[0][0][0] = a[0][0];
        if (a[0][0] < 0) dp[0][0][1] = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i > 0 && dp[i-1][j][k] != Integer.MIN_VALUE) {
                        int v = dp[i-1][j][k];
                        dp[i][j][k] = Math.max(dp[i][j][k], v + a[i][j]);
                        if (a[i][j] < 0 && k < 2) {
                            dp[i][j][k+1] = Math.max(dp[i][j][k+1], v);
                        }
                    }
                    if (j > 0 && dp[i][j-1][k] != Integer.MIN_VALUE) {
                        int v = dp[i][j-1][k];
                        dp[i][j][k] = Math.max(dp[i][j][k], v + a[i][j]);
                        if (a[i][j] < 0 && k < 2) {
                            dp[i][j][k+1] = Math.max(dp[i][j][k+1], v);
                        }
                    }
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) ans = Math.max(ans, dp[m-1][n-1][k]);
        return ans;
    }
}