package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void BFS(ArrayList<ArrayList<Integer>> adj, int s){
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adj.size()];
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for(int i : adj.get(cur)){
                if(visited[i] == false){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
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

        BFS(adj, 0);
    }
}
