import java.util.*;
public class BellmanFordAlgorithm {
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFordAlgo(graph, 0);

    }
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        
        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanFordAlgo(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if (i!=0) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length; 

        //Algorithm - O(V)
        for(int i=0; i<V-1; ++i) {
            //Edges - O(E);
            for(int j=0; j<graph.length; ++j) {
                for(int k=0; k<graph[j].size(); ++k) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    if (dist[u]+w < dist[v]) {
                        dist[v] = dist[u]+w;
                    }
                }
            }
        }
        //Hence; TC - O(V*E)
        for(int i=0; i<graph.length; ++i) {
            System.out.print(dist[i] + " ");
        }           
        System.out.println();
    }
}


/*
RATHER THAN THIS WE CAN STOR EDGES IN AN ARRAYLIST(NO NEED OF INDEX)
 
 public static void bellmanFordAlgo(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];
        for(int i=0; i<graph.length; i++) {
            if (i!=0) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //Algorithm - O(V)
        for(int i=0; i<V-1; ++i) {
            //Edges - O(E);
            for(int j=0; j<graph.length; ++j) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int w = e.wt;
                if (dist[u]+w < dist[v]) {
                    dist[v] = dist[u]+w;
                }
            }
        }
        //Hence; TC - O(V*E)
        for(int i=0; i<graph.length; ++i) {
            System.out.print(dist[i] + " ");
        }           
        System.out.println();
    }
  
    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));
        
        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }
 */ 