import java.util.ArrayList;
public class BeautifulArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        divideAndConquer(1, 1, res, 5);
        System.out.println(res);

        // System.out.println(beautifulArray(5));
    }
    // Approach => 1
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i=2; i<=n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer e:ans) {
                if (2*e <= n) temp.add(2*e);
            }
            for (Integer e:ans) {
                if (2*e-1 <= n) temp.add(2*e-1);
            }
            ans = temp;
        }
        return ans;
    }

    //Approach => 2
    public static void divideAndConquer(int start, int increment, ArrayList<Integer> res, int n) {
        if (start + increment > n) {
            res.add(start);
            return;
        }
        divideAndConquer(start, 2*increment, res, n);
        divideAndConquer(start+increment, 2*increment, res, n);
    }
}