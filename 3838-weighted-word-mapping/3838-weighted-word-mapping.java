class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String w : words) {
            int sum = 0;

            for (char c : w.toCharArray()) {
                sum += weights[c - 'a'];
            }

            ans.append((char) ('z' - (sum % 26)));
        }

        return ans.toString();
    }
}