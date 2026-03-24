import java.util.*;

class Twitter {
    static class T {
        int id, t;
        T next;
        T(int id, int t) {
            this.id = id;
            this.t = t;
        }
    }
    
    Map<Integer, Set<Integer>> f;
    Map<Integer, T> m;
    int time;
    
    public Twitter() {
        f = new HashMap<>();
        m = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int u, int tw) {
        time++;
        T n = new T(tw, time);
        n.next = m.get(u);
        m.put(u, n);
    }
    
    public List<Integer> getNewsFeed(int u) {
        PriorityQueue<T> pq = new PriorityQueue<>((a,b)->b.t-a.t);
        f.putIfAbsent(u, new HashSet<>());
        f.get(u).add(u);
        
        for(int x : f.get(u)) {
            if(m.containsKey(x)) pq.add(m.get(x));
        }
        
        List<Integer> r = new ArrayList<>();
        
        while(!pq.isEmpty() && r.size()<10) {
            T c = pq.poll();
            r.add(c.id);
            if(c.next != null) pq.add(c.next);
        }
        
        return r;
    }
    
    public void follow(int a, int b) {
        f.putIfAbsent(a, new HashSet<>());
        f.get(a).add(b);
    }
    
    public void unfollow(int a, int b) {
        if(f.containsKey(a)) f.get(a).remove(b);
    }
}