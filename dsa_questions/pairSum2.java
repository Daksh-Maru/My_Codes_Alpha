import java.util.ArrayList;

public class pairSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 100;
        System.out.println(pivotPoint(list));
        System.out.println(pairSum(list, target));
    }
    public static int pivotPoint(ArrayList<Integer> list) {
        int si=0, ei=list.size()-1;
        while (si<=ei) {
            int mid = si + (ei-si)/2;
            if (list.get(mid)<list.get(mid-1)){
                return mid;
            } 
            else if (list.get(mid)>list.get(ei) && list.get(mid)>list.get(si)) {
                si = mid+1;
            } else {
                ei = mid-1;
            }
        }
        return -1;
    }
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int lp = pivotPoint(list), rp = lp-1;
        int n = list.size();
        while (lp!=rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                return true;
            } else if (sum > target) {
                rp = (n + rp -1)%n;     /*******/
            } else {
                lp = (lp + 1)%n;        /*******/
            }
        }
        return false;
    }
}