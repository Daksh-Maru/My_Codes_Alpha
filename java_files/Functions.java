import java.util.*;

import javax.swing.text.AbstractDocument.LeafElement;
    public class Functions {
        public static void main(String []args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            DectoBin(n);
            //BintoDec(n);
        }
        public static void DectoBin(int n) {
            int bin=0;
            int i=0;
            int rem;
            while (n > 0) {
                rem = n%2;
                bin = bin + (rem * (int)Math.pow(10, i));
                i++;
                n/=2;
            }
            System.out.println(bin);
        }
        public static void BintoDec(int n) {
            int dec=0;
            int i=0;
            int lastdigit;
            while (n > 0) {
                lastdigit = n%10;
                dec = dec + (lastdigit * (int)Math.pow(2, i));
                i++;
                n/=10;
            }
            System.out.println(dec);
        }
    }