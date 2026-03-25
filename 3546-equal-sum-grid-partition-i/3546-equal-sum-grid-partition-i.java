class Solution {
    public boolean canPartitionGrid(int[][] g) {
        int m = g.length, n = g[0].length;
        long t = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t += g[i][j];
            }
        }
        
        if (t % 2 != 0) return false;
        
        long s = 0;
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                s += g[i][j];
            }
            if (s * 2 == t) return true;
        }
        
        s = 0;
        
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                s += g[i][j];
            }
            if (s * 2 == t) return true;
        }
        
        return false;
    }
}