import java.util.*;
public class ConnectingCities {
    public static void main(String[] args) {
        int n = 5;
        int cities[][] = {{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        // the int values are the cost src-->i dest-->j;
        System.out.println(connectingCities(cities));
    }
    //src is the int of firstindex. Hence, we will only store dest, cost in Edge Class.
    static class Edge implements Comparable<Edge> {
        int dest, cost;
        public Edge(int d, int c) {
            this.dest=d;
            this.cost=c;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.cost-e2.cost;
        }
    }
    public static int connectingCities(int cities[][]) {
        boolean vis[] = new boolean[cities.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int minCost = 0;
        pq.add(new Edge(0,0)); //1st 0-->currNode 2nd 0-->cost;
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                minCost+=curr.cost; //Updating the minCost
                for (int i=0; i<cities[curr.dest].length; ++i) { //traversing cities all columns one by one.
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i])); //iterator i will itself act as destination. stored with its cost;
                    }
                }
            }
        }
        return minCost;
    }
}
