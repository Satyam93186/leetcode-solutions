class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> s = new HashSet<>();

        for (int x : arr1) {
            String t = String.valueOf(x);

            for (int i = 1; i <= t.length(); i++) {
                s.add(t.substring(0, i));
            }
        }

        int ans = 0;

        for (int x : arr2) {
            String t = String.valueOf(x);

            for (int i = 1; i <= t.length(); i++) {
                if (s.contains(t.substring(0, i))) {
                    ans = Math.max(ans, i);
                }
            }
        }

        return ans;
    }
}