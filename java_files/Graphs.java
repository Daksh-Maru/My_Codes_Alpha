import java.util.*;
import java.util.LinkedList;
public class Graphs {
    public static void main(String[] args) {
        /*
                1-----3
               /      | \
              0       |  5 --- 6
               \      | /
                2-----4
         */

        int V = 7;  //Vertices
        ArrayList<Edge>[] graph = new ArrayList[V]; //By default at every index --> null
        createGraph(graph);
        bfs(graph);
        System.out.println();
        // dfs(graph);
        System.out.println();
        System.out.println(detectCycle(graph));
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));
        System.out.println(isCycle(graph));
        topSort(graph);
    }
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }
    /*Code for topological sorting with use of BFS --> only in DAGs */
    //This is for calc [in degree] array of all the nodes
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].size(); j++) {
                indeg[graph[i].get(j).dest]++;
            }
        }
    }
    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr + " ");

            for (int i=0; i<graph[curr].size(); ++i) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    /*Code for Topological Sorting --> only in DAGs --> using DFS */ 
    public static void topSortDFS(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s); //modified dfs
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    
    /*Yo detect cycle in an directed graph */
    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            } 
            else if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    /*To detect cycle in an undirected graph */
    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } 
            else if (vis[e.dest] && e.dest!=par) {
                return true;
            }
        }
        return false;
    }
    /*Sometimes we can come across the cases where graph is divided into different parts with disjoint nodes */

    // bfs (BREADTH FIRST SEARCH)
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]) {   //O(V+E) <-- important
        Queue<Integer> q = new java.util.LinkedList<>();
        
        //Starting from 0
        q.add(0); 
        while(!q.isEmpty()) {
            int curr = q.remove();
            //If not visited then perform following steps.
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i=0; i<graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest); //get(i) will give us edge and we need its dest.
                }
            }
        }
    }


    //dfs (DEPTH FIRST SEARCH)
    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) { //O(V+E)vertices and edges
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) return true;
        }
        return false;
    }
}