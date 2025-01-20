package Graph;

import java.util.*;

class GraphDijsktra {
    private int V;
    public List<List<iPair>> adj;

    GraphDijsktra(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w));
    }

    void shortestPathDijsktra(int src, int d) {
        // for(int i = 0;i<adj.size();i++){
        //     for(int j = 0;j<adj.get(i).size();j++){
        //         System.out.print(adj.get(i).get(j).first+ " " + adj.get(i).get(j).second + " ");
        //     }
        //     System.out.println();
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>(V);
        int[] dist = new int[V];
        int[] par = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(par, -1);

        pq.add(src);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll();

            for (iPair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    par[v.first] = u;
                    dist[v.first] = dist[u] + v.second;
                    pq.add(v.first);
                }
            }
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        int curr = d;
        path.add(d);
        while(par[curr] != -1){
            path.add(par[curr]);
            curr = par[curr];
        }

        for(int i = path.size() - 1; i>=0;i--){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
        System.out.println(dist[d]);
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

public class ShortestPathDijsktra {
    public static void main(String[] args) {
        int V = 9;
        GraphDijsktra g = new GraphDijsktra(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPathDijsktra(0,8);
    }
}