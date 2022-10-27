import java.util.*;

public class NextGreaterE {
    public static int[] nextGreaterElement(int[] arr, int[] res) {
        Stack<Integer> s = new Stack<>();
        for (int i=arr.length-1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                res[i] = -1;
            }
            else {
                res[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return res;
    }
    // -- By doing minimal changes in the above code;
    //next Greater left
    //next Small right
    //next Small left

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] res = new int[arr.length];
        nextGreaterElement(arr, res);
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
        
    }
}