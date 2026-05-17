class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] v = new boolean[arr.length];
        return dfs(arr, start, v);
    }

    boolean dfs(int[] arr, int i, boolean[] v) {
        if (i < 0 || i >= arr.length || v[i]) return false;
        if (arr[i] == 0) return true;

        v[i] = true;

        return dfs(arr, i + arr[i], v) || dfs(arr, i - arr[i], v);
    }
}