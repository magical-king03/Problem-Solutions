package Graph;
import java.util.*;

public class ShortestPathBFS {

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int s, ArrayList<Integer> par, ArrayList<Integer> dist){
        Queue<Integer> queue = new LinkedList<>();
        dist.set(s, 0);
        queue.add(s);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : adj.get(cur)){
                if(dist.get(i) == Integer.MAX_VALUE){
                    dist.set(i, dist.get(cur) + 1);
                    par.set(i, cur);
                    queue.add(i);
                }
            }
        }
    }

    public static void printShortestPath(ArrayList<ArrayList<Integer>> adj, int s, int d, int V){
        ArrayList<Integer> par = new ArrayList<>(Collections.nCopies(V, -1));
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));
        
        bfs(adj, s, par, dist);

        if(dist.get(d) == Integer.MAX_VALUE){
            System.out.println("No connection between source an destination!!");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int curr = d;
        path.add(d);
        while(par.get(curr) != -1){
            path.add(par.get(curr));
            curr = par.get(curr);
        }

        for(int i = path.size() - 1; i>=0;i--){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
        System.out.println(dist.get(d));
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

        printShortestPath(adj, 2, 4, V);
    }
}
