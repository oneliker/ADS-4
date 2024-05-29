import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        WeightedGraph<String> graph = new WeightedGraph<>();

        Map<String, Vertex<String>> vertices = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            System.out.println("Enter the name of vertex " + (i + 1) + ":");
            String vertexName = scanner.next();
            Vertex<String> vertex = new Vertex<>(vertexName);
            vertices.put(vertexName, vertex);
            graph.addEdge(vertex, vertex, 0.0); // Add a self-loop with weight 0
        }

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        for (int i = 0; i < numEdges; i++) {
            System.out.println("Enter the name of vertex 1:");
            String vertex1Name = scanner.next();
            System.out.println("Enter the name of vertex 2:");
            String vertex2Name = scanner.next();
            System.out.println("Enter the weight of the edge:");
            double weight = scanner.nextDouble();

            Vertex<String> vertex1 = vertices.get(vertex1Name);
            Vertex<String> vertex2 = vertices.get(vertex2Name);

            graph.addEdge(vertex1, vertex2, weight);
        }

        System.out.println("Enter the starting vertex:");
        String startVertexName = scanner.next();
        Vertex<String> startVertex = vertices.get(startVertexName);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        bfs.search(startVertex);

        System.out.println();

        DijkstraSearch<String> dfs = new DijkstraSearch<>(graph);
        dfs.search(startVertex);
    }
}