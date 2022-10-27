import java.util.*;
    public class trapwater {
        public static int trappingRainwater (int height[]) {

            //calculate left max boundary - array

            // int leftMax[] = new int [height.length];
            // leftMax[0] = height[0];
            // for(int i = 1; i < height.length; i++) {
            //     leftMax[i] = Math.max(height[i], leftMax[i-1]); 
            // }
            
            // //calculate right max boundary - array

            // int rightMax[] = new int [height.length];
            // rightMax[height.length - 1] = height[height.length - 1];
            // for (int i = height.length - 2; i >= 0; i--) {
            //     rightMax[i] = Math.max(height[i], rightMax[i+1]);
            // }

            // //loop
            // int trappedWater = 0;
            // for (int i = 0; i < height.length; i++) {
            //     //waterLevel = min(leftmax bound, rightmax bound)
            //     int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //     //trapped water = waterLevel - height[i]
            //     trappedWater = waterLevel - height[i];
            // }

            // return trappedWater;
            
            int n = height.length;
            int l=0, res=0, r=n-1;
            int lMax=height[l], rMax=height[r];

            while (l<r) {
                if (lMax<rMax) {
                    l++;
                    lMax=Math.max(lMax, height[l]);
                    res+=lMax-height[l];
                } else {
                    r--;
                    rMax=Math.max(rMax, height[r]);
                    res+=rMax-height[r];
                }
            }        
            return res;
        }
        public static void main (String args[]) {
            int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            System.out.println(trappingRainwater(height));
        }
    }