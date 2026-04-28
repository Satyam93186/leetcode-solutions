import java.util.*;

class Solution {
    public int minOperations(int[][] g, int x) {
        int n = g.length, m = g[0].length;
        int[] a = new int[n * m];
        int k = 0;

        for (int[] r : g) {
            for (int v : r) {
                a[k++] = v;
            }
        }

        int b = a[0];
        for (int v : a) {
            if ((v - b) % x != 0) return -1;
        }

        Arrays.sort(a);
        int mid = a[a.length / 2];
        int ans = 0;

        for (int v : a) {
            ans += Math.abs(v - mid) / x;
        }

        return ans;
    }
}