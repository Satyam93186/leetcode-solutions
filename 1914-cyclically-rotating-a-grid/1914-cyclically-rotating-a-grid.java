class Solution {
    public int[][] rotateGrid(int[][] g, int k) {
        int m = g.length, n = g[0].length;
        int layers = Math.min(m, n) / 2;

        for (int l = 0; l < layers; l++) {

            int top = l, left = l;
            int bottom = m - l - 1;
            int right = n - l - 1;

            java.util.ArrayList<Integer> a = new java.util.ArrayList<>();

            for (int j = left; j <= right; j++) a.add(g[top][j]);
            for (int i = top + 1; i <= bottom - 1; i++) a.add(g[i][right]);
            for (int j = right; j >= left; j--) a.add(g[bottom][j]);
            for (int i = bottom - 1; i >= top + 1; i--) a.add(g[i][left]);

            int sz = a.size();
            int r = k % sz;

            java.util.ArrayList<Integer> b = new java.util.ArrayList<>();

            for (int i = 0; i < sz; i++) {
                b.add(a.get((i + r) % sz));
            }

            int idx = 0;

            for (int j = left; j <= right; j++) g[top][j] = b.get(idx++);
            for (int i = top + 1; i <= bottom - 1; i++) g[i][right] = b.get(idx++);
            for (int j = right; j >= left; j--) g[bottom][j] = b.get(idx++);
            for (int i = bottom - 1; i >= top + 1; i--) g[i][left] = b.get(idx++);
        }

        return g;
    }
}