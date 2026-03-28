import java.util.*;

class Solution {
    public String findTheString(int[][] l) {
        int n = l.length;

        for (int i = 0; i < n; i++)
            if (l[i][i] != n - i)
                return "";

        char[] w = new char[n];
        char c = 'a';

        for (int i = 0; i < n; i++) {
            if (w[i] != 0) continue;
            if (c > 'z') return "";
            for (int j = i; j < n; j++)
                if (l[i][j] > 0)
                    w[j] = c;
            c++;
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (w[i] == w[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else
                    dp[i][j] = 0;

                if (dp[i][j] != l[i][j])
                    return "";
            }
        }

        return new String(w);
    }
}