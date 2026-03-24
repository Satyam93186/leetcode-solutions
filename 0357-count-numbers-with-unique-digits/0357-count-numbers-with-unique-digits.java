class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;

        int ans = 10, u = 9, a = 9;

        for(int i = 2; i <= n; i++) {
            u *=a;
            ans += u;
            a--;
        }
        return ans;
    }
}