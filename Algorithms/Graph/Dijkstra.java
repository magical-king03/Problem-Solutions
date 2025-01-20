package Graph;

import java.util.*;

class Graph {
    private int V;
    public List<List<iPair>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w)); // Assuming undirected graph
    }

    void shortestPath(int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.second));
        int[] dist = new int[V];
        int[] par = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(par, -1);

        pq.add(new iPair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            iPair current = pq.poll();
            int u = current.first;

            for (iPair neighbor : adj.get(u)) {
                int v = neighbor.first;
                int weight = neighbor.second;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    par[v] = u;
                    pq.add(new iPair(v, dist[v]));
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        int V = 9;
        Graph g = new Graph(V);

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

        g.shortestPath(1);
    }
}



// Vertex Distance from Source
// 0               4
// 1               0
// 2               8
// 3               15
// 4               22
// 5               12
// 6               12
// 7               11
// 8               10