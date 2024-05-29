import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, Map<Vertex<V>, Double>> weightedAdjacencyList;

    public WeightedGraph() {
        weightedAdjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        weightedAdjacencyList.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
        addVertex(source);
    }

    public Map<Vertex<V>, Map<Vertex<V>, Double>> getWeightedAdjacencyList() {
        return weightedAdjacencyList;
    }
}