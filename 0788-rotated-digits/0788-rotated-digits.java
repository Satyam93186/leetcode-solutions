class Solution {
    public int rotatedDigits(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (f(i)) c++;
        }
        return c;
    }

    boolean f(int x) {
        boolean ch = false;
        while (x > 0) {
            int d = x % 10;
            if (d == 3 || d == 4 || d == 7) return false;
            if (d == 2 || d == 5 || d == 6 || d == 9) ch = true;
            x /= 10;
        }
        return ch;
    }
}