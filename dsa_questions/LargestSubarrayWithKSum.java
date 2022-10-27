import java.util.*;
public class LargestSubarrayWithKSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int k = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, count)
        int sum = 0;
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum-k) || sum-k==0) {
                count+=map.getOrDefault(sum-k, 1); 
                //Default case if sum-k==0;
            } 
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println("No. of subarrays with sum = k : " + count);
    }
}