import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] dp = new int[e.length];
        int len = 0;

        for (int[] x : e) {
            int h = x[1];
            int i = Arrays.binarySearch(dp, 0, len, h);
            if (i < 0) i = -(i + 1);
            dp[i] = h;
            if (i == len) len++;
        }

        return len;
    }
}