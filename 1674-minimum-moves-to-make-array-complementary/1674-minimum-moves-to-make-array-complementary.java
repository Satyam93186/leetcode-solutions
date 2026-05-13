class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] d = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int l = Math.min(a, b) + 1;
            int r = Math.max(a, b) + limit;
            int s = a + b;

            d[2] += 2;
            d[l] -= 1;
            d[s] -= 1;
            d[s + 1] += 1;
            d[r + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;
        int cur = 0;

        for (int i = 2; i <= 2 * limit; i++) {
            cur += d[i];
            ans = Math.min(ans, cur);
        }

        return ans;
    }
}