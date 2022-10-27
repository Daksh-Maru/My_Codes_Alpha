import java.util.*; 

public class InterleaveQueue {
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> firstH = new LinkedList<>();
        int size = q.size()/2;
        for (int i=0; i<size; i++) {
            firstH.add(q.remove());
        }
        while (!firstH.isEmpty()) {
            q.add(firstH.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        interleave(q);
        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}