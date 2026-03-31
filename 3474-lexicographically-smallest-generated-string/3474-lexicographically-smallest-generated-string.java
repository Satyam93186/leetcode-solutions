class Solution {
    public String generateString(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int len = n + m - 1;
        char[] w = new char[len];
        for (int i = 0; i < len; i++) w[i] = '?';

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (w[i + j] == '?' || w[i + j] == s2.charAt(j)) {
                        w[i + j] = s2.charAt(j);
                    } else return "";
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (w[i] == '?') w[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'F') {
                boolean ok = false;
                for (int j = 0; j < m; j++) {
                    if (w[i + j] != s2.charAt(j)) {
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    boolean changed = false;
                    for (int j = m - 1; j >= 0 && !changed; j--) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != s2.charAt(j)) {
                                char old = w[i + j];
                                w[i + j] = c;

                                boolean valid = true;
                                for (int k = 0; k < n; k++) {
                                    if (s1.charAt(k) == 'T') {
                                        for (int x = 0; x < m; x++) {
                                            if (w[k + x] != s2.charAt(x)) {
                                                valid = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!valid) break;
                                }

                                if (valid) changed = true;
                                else w[i + j] = old;

                                if (changed) break;
                            }
                        }
                    }
                    if (!changed) return "";
                }
            }
        }

        return new String(w);
    }
}