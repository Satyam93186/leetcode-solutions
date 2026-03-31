import java.util.*;

class Solution {
    public int minRemoval(int[] a, int k) {
        Arrays.sort(a);
        int n = a.length, j = 0, mx = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && (long)a[j] <= (long)a[i] * k) j++;
            mx = Math.max(mx, j - i);
        }

        return n - mx;
    }
}