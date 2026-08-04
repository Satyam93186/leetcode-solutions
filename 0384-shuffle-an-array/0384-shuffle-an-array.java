import java.util.*;

class Solution {
    int[] o, a;
    Random r;

    public Solution(int[] nums) {
        o = nums.clone();
        a = nums.clone();
        r = new Random();
    }
    
    public int[] reset() {
        a = o.clone();
        return a;
    }
    
    public int[] shuffle() {
        for(int i=0;i<a.length;i++){
            int j = i + r.nextInt(a.length - i);
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        return a;
    }
}