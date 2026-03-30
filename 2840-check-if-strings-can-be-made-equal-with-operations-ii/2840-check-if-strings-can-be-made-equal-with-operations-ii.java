import java.util.*;

class Solution {
    public boolean checkStrings(String a, String b) {
        int n = a.length();
        int[] e1 = new int[26], o1 = new int[26];
        int[] e2 = new int[26], o2 = new int[26];

        for(int i=0;i<n;i++){
            if(i%2==0){
                e1[a.charAt(i)-'a']++;
                e2[b.charAt(i)-'a']++;
            }else{
                o1[a.charAt(i)-'a']++;
                o2[b.charAt(i)-'a']++;
            }
        }

        return Arrays.equals(e1,e2) && Arrays.equals(o1,o2);
    }
}