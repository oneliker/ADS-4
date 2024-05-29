import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public void search(Vertex<V> startVertex) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>((v1, v2) -> distances.get(v1).compareTo(distances.get(v2)));

        distances.put(startVertex, 0.0);
        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> vertex = priorityQueue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : vertex.getAdjacentVertices().entrySet()) {
                Vertex<V> adjacent = entry.getKey();
                double distance = distances.get(vertex) + entry.getValue();

                if (!distances.containsKey(adjacent) || distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    previous.put(adjacent, vertex);
                    priorityQueue.add(adjacent);
                }
            }
        }

        System.out.println("Dijkstra's traversal:");
        printShortestPath(startVertex, distances, previous);
    }

    private void printShortestPath(Vertex<V> startVertex, Map<Vertex<V>, Double> distances, Map<Vertex<V>, Vertex<V>> previous) {
        for (Vertex<V> vertex : distances.keySet()) {
            if (vertex != startVertex) {
                System.out.print("Shortest path from " + startVertex.getData() + " to " + vertex.getData() + ": ");
                printPath(vertex, previous);
                System.out.println(" with distance " + distances.get(vertex));
            }
        }
    }

    private void printPath(Vertex<V> vertex, Map<Vertex<V>, Vertex<V>> previous) {
        if (vertex != null) {
            printPath(previous.get(vertex), previous);
            System.out.print(vertex.getData() + " ");
        }
    }
}