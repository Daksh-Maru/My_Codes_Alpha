import java.util.*;

public class PriorityQueues {
    public static void main(String[] args) {
        //1, 2, 3, 4, 5
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }

    static class Student implements Comparable<Student> { //Comparable<Student> is an interface inbuilt in java.
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        //Funcion overriding[Its from Comparable Interface]
        @Override
        public int compareTo(Student s2) {
            return this.rank-s2.rank;
        }
    }
}