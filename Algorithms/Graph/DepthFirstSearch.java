package Graph;

import java.util.ArrayList;

public class DepthFirstSearch {

    public static void DFSRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s){
        visited[s] = true;
        System.out.print(s + " ");
        for(int i : adj.get(s)){
            if(!visited[i]){
                DFSRec(adj, visited, i);
            }
        }
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        DFSRec(adj, visited, s);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        DFS(adj, 0);
    }
}
