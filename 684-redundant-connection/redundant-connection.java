class Solution {
    private int parent[];
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];

        // Initializing parent array
        for (int i=1;i<=n;i++) {
            parent[i]=i;
        }

        // Process edges
        for(int edge[]:edges){
            if(!union(edge[0],edge[1])){
                return edge; // This edge causes a cycle
            }
        }
        return new int[0]; // Should not reach here
    }

    // Find function with path compression
    private int find(int node){
        if (parent[node]!=node){
            parent[node]=find(parent[node]); // Path compression
        }
        return parent[node];
    }

    // Union function
    private boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);

        if(pu==pv) return false; // Cycle detected
        parent[pu]=pv; // Merge components
        return true;
    }
}