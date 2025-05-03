// Student Name: Nithika Wickramasinghe
// Student ID: 20230271 / w2083052

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int n; // Number of nodes
    List<Edge>[] adjList; // Adjacency list
    private int edgeCount; // To store the number of original directed edges

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        this.n = n;
        this.edgeCount = 0;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int capacity) {

        if (capacity < 0) {
            return;
        }

        Edge forward = new Edge(from, to, capacity); // Added 'from' for clarity
        Edge backward = new Edge(to, from, 0); // Reverse edge starts with 0 capacity

        forward.reverse = backward;
        backward.reverse = forward;

        adjList[from].add(forward);
        adjList[to].add(backward); // Important for residual graph
        this.edgeCount++; // Increment count for each original edge added
    }

    public List<Edge> getEdges(int node) {
        return adjList[node];
    }

    public int getNodeCount() {
        return n;
    }

    public int getEdgeCount() {
        return edgeCount;
    }
}