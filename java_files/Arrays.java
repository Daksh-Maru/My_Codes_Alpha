import java.util.*;

public class Arrays {
    public static void main(String args[]) {
        int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        maxsubarraysum(numbers);
    }
    // KADANES ALGORITHM
    public static void maxsubarraysum(int numbers[]) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        
        // If the sum if negative then we make it to 0; therefore considering only the positive sums.
        for (int i=0; i<numbers.length; i++) {
            cs += numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
            }
        System.out.println(ms);
    }   
}


//                  Q5 (Arrays Assignment)
// public static List<List<Integer>> threeSum (int nums[]) {
//     List<List<Integer>> result = new ArrayList <List<Integer>> ();
//     for (int i=0; i<nums.length; i++) {
//         for (int j=i+1; j<nums.length; j++) {
//             for (int k=j+1; k<nums.length; k++) {
//                 if (nums[i] + nums[j] + nums[k] == 0) {
//                     List<Integer> triplet = new ArrayList < Integer > ();
//                     triplet.add(nums[i]);
//                     triplet.add(nums[j]);
//                     triplet.add(nums[k]);
//                     Collections.sort(triplet);
//                     result.add(triplet);
// ;               }
//             }
//         }
//     }
//     result = new ArrayList<List<Integer>> (new LinkedHashSet<List<Integer>> (result));
//     return result;
//}