import java.util.*;

class Solution {
    public int maxPathScore(int[][] g, int k) {
        int m = g.length, n = g[0].length;

        int[][][] dp = new int[m][n][k+1];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                Arrays.fill(dp[i][j], -1);

        dp[0][0][0] = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int c=0;c<=k;c++){
                    if(dp[i][j][c] == -1) continue;

                    if(i+1 < m){
                        int nc = c + (g[i+1][j]==0?0:1);
                        if(nc <= k){
                            int ns = dp[i][j][c] + g[i+1][j];
                            dp[i+1][j][nc] = Math.max(dp[i+1][j][nc], ns);
                        }
                    }

                    if(j+1 < n){
                        int nc = c + (g[i][j+1]==0?0:1);
                        if(nc <= k){
                            int ns = dp[i][j][c] + g[i][j+1];
                            dp[i][j+1][nc] = Math.max(dp[i][j+1][nc], ns);
                        }
                    }
                }
            }
        }

        int ans = -1;
        for(int c=0;c<=k;c++){
            ans = Math.max(ans, dp[m-1][n-1][c]);
        }

        return ans;
    }
}