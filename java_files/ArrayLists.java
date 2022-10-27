import java.util.ArrayList;
public class ArrayLists {
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
       ArrayList<Integer> list1 = new ArrayList<>();
       ArrayList<Integer> list2 = new ArrayList<>();
       ArrayList<Integer> list3 = new ArrayList<>();
       for (int i=1; i<=5; i++) {
        list1.add(i*1);  //1 2 3 4 5
        list2.add(i*2);  //2 4 6 8 10
        list3.add(i*3);  // 3 6 0 12 15
       }
       mainList.add(list1);
       mainList.add(list2);
       mainList.add(list3);

       System.out.println(mainList);
    }
}

//Swap Operation
// int idx1 = 1, idx2 = 3;
// int temp = list.get(idx1);
// list.set(idx1, list.get(idx2));
// list.set(idx2, temp);
// System.out.println(list


// //Add Operation

// list.add(3, 9);     //O(n);
// System.out.println(list);
// //Get Operation
// int element = list.get(2);      //O(1);
// System.out.println(" " + element);
// //Delete
// list.remove(2);         //O(n);
// System.out.println(list);
// //Set Operation
// list.set(2, 10);            //O(n);
// System.out.println(list);
// //Contains Element
// System.out.println(list.contains(5));       //O(n);
// //Size of array
// System.out.println(list.size());        
// //To iterate
// for (int i=0; i<list.size(); i++) {
//     System.out.print(list.get(i) + " ");
// }
// System.out.println();