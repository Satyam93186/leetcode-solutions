class Solution {
    public String decodeCiphertext(String s, int r) {
        if (r == 1) return s;

        int n = s.length();
        int c = n / r;

        char[][] m = new char[r][c];

        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = s.charAt(k++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < c; j++) {
            int i = 0, y = j;
            while (i < r && y < c) {
                sb.append(m[i][y]);
                i++;
                y++;
            }
        }

        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') end--;

        return sb.substring(0, end + 1);
    }
}