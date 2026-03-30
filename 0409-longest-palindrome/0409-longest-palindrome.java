class Solution {
    public int longestPalindrome(String s) {
        int[] f=new int[128];

        for(char c:s.toCharArray())f[c]++;

        int r=0, o=0;
        for(int v:f){
            r+=v/2*2;

            if(v%2==1) o=1;
        }
        return r+o;
    }
}