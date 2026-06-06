class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int x : nums) {
            total += x;
        }

        int[] ans = new int[n];
        int left = 0;

        for(int i = 0; i < n; i++){
            int right = total - left - nums[i];
            ans[i] = Math.abs(left - right);
            left += nums[i];
        }

        return ans;
            }


}