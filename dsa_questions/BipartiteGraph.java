import java.nio.file.attribute.BasicFileAttributeView;
import java.util.*;
public class BipartiteGraph {
    public static void main(String args[]) {
        //If graph doesn't have cycles then by default the graph is bipartite
        /*
                       0
                     /   \
                   /      \
                 /         \
                1           2
                \          /
                 \        /
                  3 ---- 4
         
         */
        int V = 5; //vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
    static class Edge {
        int src; //source
        int dest; //destination

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int colour[] = new int[graph.length];
        //For different parts of the graph 
        for(int i=0; i<colour.length; i++) {
            colour[i] = -1; //no colour
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<graph.length; ++i) {
            if(colour[i] == -1) { //BFS
                q.add(i);
                colour[i] = 0; //yellow
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest -> neighbour
                        if(colour[e.dest] == -1) {
                            int nextCol = colour[curr]==0 ? 1 : 0;
                            colour[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if (colour[e.dest] == colour[curr]) {
                            return false; //neighbour has the same colour 
                        }
                    }
                }
            }
        }
        return true;
    }
}

