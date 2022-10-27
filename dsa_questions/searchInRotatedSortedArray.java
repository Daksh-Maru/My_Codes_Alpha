import java.util.*;
public class searchInRotatedSortedArray {
    public static void main(String []args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(arr, target, 0, arr.length-1));
        // System.out.println(search(nums, target);
    }
    public static int search(int[] arr, int tar, int si, int ei) {
        if (si > ei) return -1;    // Base Case (don't put >=)
        int mid = si + (ei - si)/2;

        if (arr[mid] == tar) return mid;  // If by instance arr[mid] becomes == target; (JACKPOT)

        if (arr[mid] >= arr[si]) {   // If mid exists in Line 1 (4, 5, 6, 7)
            if (tar <= arr[mid] && tar >= arr[si]) {        // If target is between si and mid
                return search(arr, tar, si, mid-1);
            } else {
                return search(arr, tar, mid+1, ei);
            }
        } else {                                            // If mid exists in Line 2 (0, 1, 3)
            if (arr[mid] <= tar && tar <= arr[ei]) {        // If target is between mid and ei
                return search(arr, tar, mid+1, ei);
            } else {                                        
                return search(arr, tar, si, mid-1);
            }
        }

    }
    
    
    
    
    




    
    //function which optimizes the search of target
    public static int search(int[] nums, int target) {
        int min = minsearch(nums);
        if (target >= nums[min] && target <= nums[nums.length-1]) {
            return findTarget(nums, min, nums.length-1, target);
        }
        else {
            return findTarget(nums, 0, min, target);
        }
    }
    //function to find the min element index
    public static int minsearch(int []nums) {
            int left = 0;
            int right = nums.length-1;
            while (left < right) {
                int mid = (left + right)/2;
                if (mid>0 && nums[mid-1]>nums[mid]) {
                    return mid;
                }
                else if (nums[mid] >= nums[left] && nums[mid] >= nums[nums.length-1]) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
            return left;
        }
        //function which finds the target
        public static int findTarget(int []nums, int left, int right, int target) {
            int l = left;
            int r = right;
            while (l <= r) {
                int mid = (l + r)/2;            
                if (nums[mid] == target) {
                    return mid;
                } 
                else if (nums[mid] > target) {
                    r = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            return -1;   
        }
    }