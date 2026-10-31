class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        java.util.Map<Integer, Integer> m = new java.util.HashMap<>();
        for (int n : nums) m.put(n, m.getOrDefault(n, 0) + 1);
        
        java.util.List<Integer>[] b = new java.util.List[nums.length + 1];
        for (int key : m.keySet()) {
            int f = m.get(key);
            if (b[f] == null) b[f] = new java.util.ArrayList<>();
            b[f].add(key);
        }
        
        int[] r = new int[k];
        int i = 0;
        
        for (int j = b.length - 1; j >= 0 && i < k; j--) {
            if (b[j] != null) {
                for (int n : b[j]) {
                    r[i++] = n;
                    if (i == k) break;
                }
            }
        }
        
        return r;
    }
}