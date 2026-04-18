class Solution {
    public int mirrorDistance(int n) {
        int r = 0, x = n;
        
        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        
        return Math.abs(n - r);
    }
}