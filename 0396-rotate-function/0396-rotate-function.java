class Solution {
    public int maxRotateFunction(int[] a) {
        int n = a.length;
        
        int s = 0, f = 0;
        for(int i = 0; i < n; i++){
            s += a[i];
            f += i * a[i];
        }
        
        int ans = f;
        
        for(int k = 1; k < n; k++){
            f = f + s - n * a[n - k];
            ans = Math.max(ans, f);
        }
        
        return ans;
    }
}