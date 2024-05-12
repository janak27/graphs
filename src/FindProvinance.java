import java.util.ArrayList;

public class FindProvinance {
    public static void main(String[] args) {
    }
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                adj.add(new ArrayList<>());
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(isConnected[i][j]==1 && i!=j){
                        adj.get(i+1).add(j+1);
                    }
                }
            }

            int vis[] = new int[n+1];

            int count = 0;

            for(int i = 1; i <= n; i++){
                if(vis[i] == 0){
                    dfs(i,adj,vis);
                    count++;
                }
            }

            return count;
        }

        public void dfs(int i , ArrayList<ArrayList<Integer>> adj, int[] vis){
            vis[i] = 1;
            for(int node : adj.get(i)){
                if(vis[node] == 0){
                    dfs(node, adj, vis);
                }
            }
        }
}
