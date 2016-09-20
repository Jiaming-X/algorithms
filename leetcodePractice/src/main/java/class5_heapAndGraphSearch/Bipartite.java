package class5_heapAndGraphSearch;

import java.util.*;

 class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<GraphNode>();
    }
  }
  
public class Bipartite {
    
    
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
        
        for (GraphNode one : graph) {
            if (!BFS(one, visited)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        visited.put(node, 0);
        queue.offerLast(node);
        
        while (!queue.isEmpty()) {
            GraphNode curr = queue.pollFirst();
            
            int currGroupNum = visited.get(curr);
            int neigGroupNum = currGroupNum == 0 ? 1 : 0;
            for (GraphNode neig : curr.neighbors) {
                if (!visited.containsKey(neig)) {
                    visited.put(neig, neigGroupNum);
                    queue.offerLast(neig);
                } else if (visited.get(curr) == currGroupNum) {
                    return false;
                }
            }
        }
        
        return true;
    }
}   
