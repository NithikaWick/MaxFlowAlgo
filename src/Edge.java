// Student Name: Nithika Wickramasinghe
// Student ID: 20230271 / w2083052

public class Edge {
    int from;       // Source node (added for easier path reconstruction/printing)
    int to;         // Destination node
    int capacity;   // Capacity of the edge
    int flow;       // Current flow
    Edge reverse;   // Reverse edge (for residual graph)

    // Constructor updated to include 'from'
    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int remainingCapacity() {
        return capacity - flow;
    }

    public void addFlow(int addedFlow) {
        if (addedFlow < 0) {
            System.err.println("Error: Negative flow increment requested.");
            return; // Or throw exception
        }
        this.flow += addedFlow;
        // Check reverse flow doesn't become negative due to floating point issues if used,
        // but with integers this subtraction is safe.
        this.reverse.flow -= addedFlow;
    }


    @Override
    public String toString() {
        return from + "->" + to + " (" + flow + "/" + capacity + ")";
    }
}