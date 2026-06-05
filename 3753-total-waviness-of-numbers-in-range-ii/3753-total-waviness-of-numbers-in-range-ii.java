class Solution {
    String s;
    long[][][][][] cntMemo;
    long[][][][][] wavMemo;
    boolean[][][][][] vis;

    private long[] dfs(int pos, int prev2, int prev1, int started, int tight) {
        if (pos == s.length()) {
            return new long[]{1, 0};
        }

        if (vis[pos][prev2][prev1][started][tight]) {
            return new long[]{
                cntMemo[pos][prev2][prev1][started][tight],
                wavMemo[pos][prev2][prev1][started][tight]
            };
        }

        vis[pos][prev2][prev1][started][tight] = true;

        long ways = 0;
        long wav = 0;

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                long[] nxt = dfs(pos + 1, 10, 10, 0, ntight);

                ways += nxt[0];
                wav += nxt[1];
            } else {
                if (started == 0) {
                    long[] nxt = dfs(pos + 1, 10, d, 1, ntight);

                    ways += nxt[0];
                    wav += nxt[1];
                } else {
                    int add = 0;

                    if (prev2 != 10) {
                        if ((prev1 > prev2 && prev1 > d) ||
                            (prev1 < prev2 && prev1 < d)) {
                            add = 1;
                        }
                    }

                    long[] nxt = dfs(pos + 1, prev1, d, 1, ntight);

                    ways += nxt[0];
                    wav += nxt[1] + nxt[0] * add;
                }
            }
        }

        cntMemo[pos][prev2][prev1][started][tight] = ways;
        wavMemo[pos][prev2][prev1][started][tight] = wav;

        return new long[]{ways, wav};
    }

    private long solve(long x) {
        if (x < 0) return 0;

        s = String.valueOf(x);

        int n = s.length();

        cntMemo = new long[n + 1][11][11][2][2];
        wavMemo = new long[n + 1][11][11][2][2];
        vis = new boolean[n + 1][11][11][2][2];

        return dfs(0, 10, 10, 0, 1)[1];
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}