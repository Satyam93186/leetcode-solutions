class Solution {
    public int xorAfterQueries(int[] a, int[][] q) {
        long mod = 1000000007;
        
        for(int[] x : q)
        {
            int l = x[0], r = x[1], k = x[2], v = x[3];
            
            for(int i = l; i <= r; i += k)
            {
                a[i] = (int)((a[i] * 1L * v) % mod);
            }
        }
        
        int ans = 0;
        for(int x : a) ans ^= x;
        
        return ans;
    }
}