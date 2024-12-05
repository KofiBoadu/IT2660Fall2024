import java.util.*;

class Main {
  public static void main(String[] args) {
    String[] vertices = {
       "Liberal Arts", 
       "Student Services", 
       "Health Careers & Sciences", 
       "Health Technologies Center", 
       "Recreation Center", 
       "Technology Learning Center", 
       "Business & Technology", 
       "Theatre"
    };

    int[][] edges = {
      {0,1}, // Liberal Arts -- Student Services
      {0, 2}, // Liberal Arts -- Health Careers & Sciences
      {1, 3}, // Student Services -- Health Technologies Center
      {1, 4}, // Student Services  --  Recreation Center
      {2, 3},  // Health Careers & Sciences -- Health Technologies Center
      {3, 4}, // Health Technologies Center -- Recreation Center
      {4, 5},  // Recreation Center -- Technology Learning Center
      {5, 6},  // Technology Learning Center -- Business & Technology
      {6, 7},  // Business & Technology -- Theatre
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this is you called it something different in your vertices!
    
    System.out.println("Paths from Business & Technology:");
    printPath(graph, dfs, "Health Technologies Center");
    printPath(graph, dfs, "Student Services");
    printPath(graph, dfs, "Recreation Center");

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));
  }


//print path to a specific vertice
public static void printPath(Graph<String> graph, UnweightedGraph<String>.SearchTree dfs, String target) {
  int targetIndex = graph.getIndex(target);
  if (targetIndex == -1) {
      System.out.println("Vertex " + target + " not found in the graph.");
      return;
  }
  List<String> path = dfs.getPath(targetIndex);
  if (path == null) {
      System.out.println("No path from Business & Technology to " + target + ".");
      return;
  }
  System.out.print("Path to " + target + ": ");
  for (int i = path.size() - 1; i >= 0; i--) {
      System.out.print(path.get(i) + (i > 0 ? " -> " : ""));
  }
  System.out.println();
}

}
