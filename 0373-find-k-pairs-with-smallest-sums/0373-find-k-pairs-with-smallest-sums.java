import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (a.length == 0 || b.length == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> (a[x[0]] + b[x[1]]) - (a[y[0]] + b[y[1]])
        );

        for (int i = 0; i < Math.min(k, a.length); i++)
            pq.offer(new int[]{i, 0});

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1];

            res.add(Arrays.asList(a[i], b[j]));

            if (j + 1 < b.length)
                pq.offer(new int[]{i, j + 1});
        }

        return res;
    }
}