import java.util.ArrayList;
import java.util.List;
public class pairSum1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;

        System.out.println(pairSum(list, target));
    }
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int si=0, ei=list.size()-1;
        while (si!=ei) {
            if (list.get(si) + list.get(ei) == target) {
                return true;
            } else if (list.get(si) + list.get(ei) > target) {
                ei--;
            } else {
                si++;
            }
        }
        return false;
    }
}
