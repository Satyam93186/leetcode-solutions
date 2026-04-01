import java.util.*;

class Solution {
    
    static class R {
        int p,h,i;
        char d;
        R(int p,int h,char d,int i){
            this.p=p; this.h=h; this.d=d; this.i=i;
        }
    }
    
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        int n = positions.length;
        
        R[] r = new R[n];
        for(int i=0;i<n;i++)
            r[i] = new R(positions[i],healths[i],directions.charAt(i),i);
        
        Arrays.sort(r,(a,b)->a.p-b.p);
        
        Stack<R> st = new Stack<>();
        
        for(R x : r)
        {
            if(x.d=='R') st.push(x);
            else
            {
                while(!st.isEmpty() && st.peek().d=='R' && x.h>0)
                {
                    if(st.peek().h < x.h)
                    {
                        x.h--;
                        st.pop();
                    }
                    else if(st.peek().h > x.h)
                    {
                        st.peek().h--;
                        x.h = 0;
                    }
                    else
                    {
                        st.pop();
                        x.h = 0;
                    }
                }
                
                if(x.h > 0) st.push(x);
            }
        }
        
        int[] res = new int[n];
        Arrays.fill(res,-1);
        
        for(R x : st) res[x.i] = x.h;
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
            if(res[i] != -1) ans.add(res[i]);
        
        return ans;
    }
}