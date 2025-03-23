import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        final long MOD = 1000000007L;
        
        List<List<long[]>> adj = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            long wt = roads[i][2];
            adj.get(u).add(new long[]{wt, v});
            adj.get(v).add(new long[]{wt, u});
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        long[] ways = new long[n];
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long node = current[1];
            long wt = current[0];
            
            for (long[] edge : adj.get((int) node)) {
                long newNode = edge[1];
                long newWt = edge[0];
                
                if (wt + newWt < dist[(int) newNode]) {
                    dist[(int) newNode] = wt + newWt;
                    pq.offer(new long[]{wt + newWt, newNode});
                    ways[(int) newNode] = ways[(int) node];
                } else if (wt + newWt == dist[(int) newNode]) {
                    ways[(int) newNode] = (ways[(int) newNode] + ways[(int) node]) % MOD;
                }
            }
        }
        
        return (int) (ways[n - 1] % MOD);
    }
}