class Solution {
    public boolean isTrionic(int[] a) {
        int n = a.length, i = 1;

        while (i < n && a[i] > a[i - 1]) i++;
        if (i == 1 || i == n) return false;

        while (i < n && a[i] < a[i - 1]) i++;
        if (i == n) return false;

        while (i < n && a[i] > a[i - 1]) i++;

        return i == n;
    }
}