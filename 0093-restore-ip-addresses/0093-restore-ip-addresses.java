import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int idx, int parts, StringBuilder cur, List<String> res) {
        if (parts == 4 && idx == s.length()) {
            res.add(cur.toString());
            return;
        }
        if (parts == 4 || idx == s.length()) return;

        int len = cur.length();

        for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {
            if (s.charAt(idx) == '0' && i > idx) break;

            int val = Integer.parseInt(s.substring(idx, i + 1));
            if (val > 255) break;

            if (cur.length() > 0) cur.append(".");
            cur.append(val);

            backtrack(s, i + 1, parts + 1, cur, res);
            cur.setLength(len);
        }
    }
}
