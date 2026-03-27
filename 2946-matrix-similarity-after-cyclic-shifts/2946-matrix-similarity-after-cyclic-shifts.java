class Solution {
    public boolean areSimilar(int[][] g, int k) {
        int m = g.length, n = g[0].length;
        k %= n;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i % 2 == 0) {
                    if(g[i][j] != g[i][(j + k) % n]) return false;
                } else {
                    if(g[i][j] != g[i][(j - k + n) % n]) return false;
                }
            }
        }
        return true;
    }
}