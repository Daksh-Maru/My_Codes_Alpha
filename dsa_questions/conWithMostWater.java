import java.util.*;
public class conWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));
    }
    public static  int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int si = 0, ei = height.size()-1;
        while (si<=ei) {
            if (height.get(si) <= height.get(ei)) {
                int ht = height.get(si), wth = ei-si;
                int currWater = ht * wth;
                maxWater = Math.max(maxWater, currWater);
                si++;
            } else {
                int ht = height.get(ei), wth = ei-si;
                int currWater = ht * wth;
                maxWater = Math.max(maxWater, currWater);
                ei--;
            }
        }
        return maxWater;
    }
}  
    //BRUTE FORCE
    
    //     int maxWater = 0;
    //     for (int i=0; i<height.size(); i++) {
    //         for (int j=i+1; j<height.size(); j++) {
    //             int ht = Math.min(height.get(i), height.get(j));
    //             int wth = j-i;
    //             int water = ht * wth;
    //             maxWater = Math.max(maxWater, water);
    //         }
    //     }
    //     return maxWater;
    // }