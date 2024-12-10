import java.util.*;

class Dijkstra {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void dijkstra(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V]; // Array to store the shortest distance from source to each node
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0; // Distance to the source itself is 0

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            // Traverse all neighbors of u
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0) { // If there is an edge between u and v
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }

        // Print the result
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 0, 30, 100},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {100, 0, 10, 60, 0}
        };
        dijkstra(graph, 0);
    }
}
