class Solution {
    public int characterReplacement(String s, int k) {
        int[] c = new int[26];
        int l = 0, maxf = 0, res = 0;

        for(int r=0;r<s.length();r++){
            int x = s.charAt(r) - 'A';
            c[x]++;
            maxf = Math.max(maxf, c[x]);

            while((r - l + 1) - maxf > k){
                c[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}