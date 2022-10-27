import java.util.*;

public class Sorting {
    public static void printarr(int []arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String [] args) {
        int []arr = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        mergeSort(arr, 0, arr.length-1);
        printarr(arr);
    }

    // MERGE SORT
    public static void mergeSort(int[] arr, int si, int ei) {    
        if (si >= ei) return;   //base case
        int mid = si + (ei - si)/2;   //to find mid
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);    //function call
    }
    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei-si+1];
        //variable defined to iterate 
        int i = si;     //left
        int j = mid+1;    //right
        int k = 0;     //index of temp
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //if some elements are left from the above while loop
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        //to save elements from temp[] to arr[]
        for (k=0,i=si; k<temp.length; k++,i++) {
            arr[i] = temp[k];
        }
    }




    // QUICK SORT.
    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) return;      // base case
        int pIdx = partition(arr, si, ei);   //function call
        quickSort(arr, si, pIdx-1);     //left part
        quickSort(arr, pIdx+1, ei);     //right part
    }
    public static int partition(int[] arr, int si, int ei) {
        //to save smaller elements before pivot and larger elements after pivot
        int pivot = arr[ei];
        int i = si-1;
        for (int j=si; j<ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // to swap the element at last index
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }




    // BUBBLE SORT
    public static void bubbleSort(int []arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // SELECTION SORT
    public static void selectionSort(int []arr) {
        for (int i=0; i<arr.length-1; i++) {
            int min = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    
    // INSERTION SORT
    public static void insertionSort(int []arr) {
        for (int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] < curr) {
                arr[prev+1] = arr[prev];
                prev--;
            } 
            arr[prev+1] = curr;
        }
    }

    // COUNTING SORT
    public static void countingSort(int []arr) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = Math.max(arr[i], max);
            }
        }

        int []count = new int [max+1];
        for (int i=0; i<arr.length; i++) {
            //To keep note of the frequency.
            count[arr[i]]++;
        }
        int j=0;
        for (int i=count.length-1; i>=0; i--) {
            while (count[i] != 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    
}   