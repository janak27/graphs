import java.util.*;

public class Graph {
    private int numVertices;
    private LinkedList<Integer> adjList[];

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    // Breadth-First Search (BFS) traversal
    public void BFS(int startingVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjList[currentVertex]) {
                queue.add(neighbor);
            }
        }
    }

    // Depth-First Search (DFS) traversal (recursive approach)
    public void DFSRecursive(int startingVertex) {
        System.out.print(startingVertex + " ");

        for (int neighbor : adjList[startingVertex]) {
            DFSRecursive(neighbor);
        }
    }

    // Depth-First Search (DFS) traversal (iterative approach)
    public void DFS(int startingVertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startingVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjList[currentVertex]) {
                stack.push(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 6;
        Graph graph = new Graph(numVertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("BFS traversal starting from vertex 0: ");
        graph.BFS(0);
        System.out.println("\nDFS traversal (recursive) starting from vertex 0: ");
        graph.DFSRecursive(0);
        System.out.println("\nDFS traversal (iterative) starting from vertex 0: ");
        graph.DFS(0);

        // Note: You can visualize the graph using libraries like Graphviz or visualize it manually.
    }
}
