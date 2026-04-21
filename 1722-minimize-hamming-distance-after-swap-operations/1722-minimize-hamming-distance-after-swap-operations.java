import java.util.*;

class Solution {
    static class DSU {
        int[] p, r;

        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (r[pa] < r[pb]) p[pa] = pb;
            else if (r[pb] < r[pa]) p[pb] = pa;
            else {
                p[pb] = pa;
                r[pa]++;
            }
        }
    }

    public int minimumHammingDistance(int[] s, int[] t, int[][] a) {
        int n = s.length;
        DSU d = new DSU(n);

        for (int[] e : a) d.union(e[0], e[1]);

        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = d.find(i);
            m.putIfAbsent(p, new HashMap<>());
            Map<Integer, Integer> f = m.get(p);
            f.put(s[i], f.getOrDefault(s[i], 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int p = d.find(i);
            Map<Integer, Integer> f = m.get(p);

            if (f.getOrDefault(t[i], 0) > 0) {
                f.put(t[i], f.get(t[i]) - 1);
            } else {
                ans++;
            }
        }

        return ans;
    }
}