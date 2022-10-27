import java.util.*;
public class UnionAndIntersectionOfArrays {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();
        //union
        for (int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println("Union : " + set.size());
        for (int i : set) {
            System.out.print(i + " ");
        }
        System.out.println();

        set.clear();
        //Intersection
        int count = 0;
        for (int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i=0; i<arr2.length; i++) {
            if (set.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
                count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println();
        System.out.println("Intersection : " + count);
    }
}
