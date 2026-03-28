class Solution {
    public int superPow(int a, int[] b) {
        int res = 1;
        a %= 1337;
        for (int d : b) {
            res = pow(res, 10) * pow(a, d) % 1337;
        }
        return res;
    }

    int pow(int x, int n) {
        int res = 1;
        x %= 1337;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x % 1337;
            x = x * x % 1337;
            n >>= 1;
        }
        return res;
    }
}