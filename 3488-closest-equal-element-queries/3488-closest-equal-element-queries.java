import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            m.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i];
            int val = nums[idx];
            List<Integer> l = m.get(val);
            
            if (l.size() == 1) {
                ans.add(-1);
                continue;
            }
            
            int pos = Collections.binarySearch(l, idx);
            
            int left = l.get((pos - 1 + l.size()) % l.size());
            int right = l.get((pos + 1) % l.size());
            
            int d1 = Math.min(Math.abs(idx - left), n - Math.abs(idx - left));
            int d2 = Math.min(Math.abs(idx - right), n - Math.abs(idx - right));
            
            ans.add(Math.min(d1, d2));
        }
        
        return ans;
    }
}