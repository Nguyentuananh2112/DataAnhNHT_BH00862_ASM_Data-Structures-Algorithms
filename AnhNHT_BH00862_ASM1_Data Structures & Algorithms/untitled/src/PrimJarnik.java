import java.util.*;

class PrimJarnik {
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

    public static void primMST(int[][] graph) {
        int V = graph.length;
        boolean[] inMST = new boolean[V]; // To track vertices included in the MST
        int[] key = new int[V]; // To store minimum weight to connect each vertex
        int[] parent = new int[V]; // To store the parent of each vertex in the MST

        Arrays.fill(key, Integer.MAX_VALUE); // Initialize all keys to infinity
        key[0] = 0; // Start from the first vertex
        parent[0] = -1; // First node is always the root of the MST

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;
            inMST[u] = true;

            // Traverse all neighbors of u
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    pq.add(new Node(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        // Print the MST
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        primMST(graph);
    }
}
