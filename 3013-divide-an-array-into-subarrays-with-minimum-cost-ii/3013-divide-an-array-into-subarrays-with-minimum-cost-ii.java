import java.util.*;

class Solution {

    long sumSmall;

    class Node {
        long val;
        int idx;

        Node(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    TreeSet<Node> small;
    TreeSet<Node> large;
    int need;

    Comparator<Node> cmp = (a, b) -> {
        if (a.val == b.val) return a.idx - b.idx;
        return Long.compare(a.val, b.val);
    };

    private void rebalance() {
        while (small.size() > need) {
            Node x = small.pollLast();
            sumSmall -= x.val;
            large.add(x);
        }

        while (small.size() < need && !large.isEmpty()) {
            Node x = large.pollFirst();
            large.remove(x);
            small.add(x);
            sumSmall += x.val;
        }

        while (!small.isEmpty() && !large.isEmpty()
                && small.last().val > large.first().val) {

            Node a = small.pollLast();
            Node b = large.pollFirst();

            sumSmall -= a.val;
            sumSmall += b.val;

            small.add(b);
            large.add(a);
        }
    }

    private void add(Node x) {
        if (small.size() < need) {
            small.add(x);
            sumSmall += x.val;
        } else if (!small.isEmpty() && x.val < small.last().val) {
            Node y = small.pollLast();
            sumSmall -= y.val;
            large.add(y);

            small.add(x);
            sumSmall += x.val;
        } else {
            large.add(x);
        }

        rebalance();
    }

    private void remove(Node x) {
        if (small.remove(x)) {
            sumSmall -= x.val;
        } else {
            large.remove(x);
        }

        rebalance();
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        need = k - 1;

        small = new TreeSet<>(cmp);
        large = new TreeSet<>(cmp);
        sumSmall = 0;

        int r = dist + 1;

        for (int i = 1; i <= r; i++) {
            add(new Node(nums[i], i));
        }

        long ans = sumSmall;

        for (int l = 2; l <= n - dist - 1; l++) {

            remove(new Node(nums[l - 1], l - 1));

            int addIdx = l + dist;
            if (addIdx < n) {
                add(new Node(nums[addIdx], addIdx));
            }

            ans = Math.min(ans, sumSmall);
        }

        return ans + nums[0];
    }
}