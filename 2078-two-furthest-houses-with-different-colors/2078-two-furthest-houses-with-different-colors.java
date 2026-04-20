class Solution {
    public int maxDistance(int[] c) {
        int n = c.length, x = 0, y = 0;

        for(int i = n - 1;  i >= 0; i--) {

            if(c[i] != c[0]) {

                x =  i;
                break;
            }
        }

        for(int i = 0; i < n; i++) {

            if(c[i] != c[n - 1]) {

                y = n - 1 - i;
                break;
            }
        }
        return Math.max(x,y);
    }
}