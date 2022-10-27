import java.util.*;
import java.util.concurrent.CountDownLatch;
    public class BitManipulation {
        public static void main (String[] args) {
            for (char i='A'; i<='Z'; i++) {
                System.out.print((char) (i | ' '));
            }
        }
        public static int nextInteger (int n) {
            int i = 0;
            while (n != 0) {
                if ((n&(1<<i)) == 1) {
                    n = clearIthBit(n, i);
                } else {
                    n = setIthBit(n, i);
                    return n;
                }
                i++;
            }
            return n;
        }

        public static int countSetBits(int n) {
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n = n >> 1;
            }
            return count;
        }         

        public static int findExponentiation (int a, int n) {
            int ans = 1;
            while (n!=0) {
                if ((n & 1) == 1) {
                    ans = ans * a;
                }
                n = n >> 1;
                a = a*a;
            }
            return ans;
        }

        public static int clearIthBit (int n, int i) {
            return (n & (~(1<<i)));
        }

        public static int setIthBit (int n, int i) {
            return (n | (1<<i));
        }

    } 

    //Check even odd [n & 1 == 0 ? even : odd;]
    //Get ith bit [n & (1<<i)]
    //Set ith bit [n | (1<<i)]
    //Clear ith bit [n & (~(1<<i))]
    //Update ith bit n = clearIthBit(n, i)        updateIthBit(n, i, newbit)
    //               int bitMask = newBit << i
    //               return n & bitMask;
    //Clear ith bits n & ((-1)<<i)
    //Clear range of bits (from i to j) a = -1 << j+1
    //                                  b = (1 << i) -1
    //                                  return n & (a | b)
    //check if Power of 2   return (n & (n-1))== 0
    //