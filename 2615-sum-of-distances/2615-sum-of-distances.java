import java.util.*;

class Solution {
    public long[] distance(int[] a) {
        int n = a.length;
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.computeIfAbsent(a[i], k -> new ArrayList<>()).add(i);
        }
        
        long[] r = new long[n];
        
        for (List<Integer> l : m.values()) {
            int k = l.size();
            long[] p = new long[k];
            p[0] = l.get(0);
            
            for (int i = 1; i < k; i++) {
                p[i] = p[i - 1] + l.get(i);
            }
            
            for (int i = 0; i < k; i++) {
                int idx = l.get(i);
                
                long left = i > 0 ? (long) idx * i - p[i - 1] : 0;
                long right = i < k - 1 ? (p[k - 1] - p[i]) - (long) idx * (k - i - 1) : 0;
                
                r[idx] = left + right;
            }
        }
        
        return r;
    }
}