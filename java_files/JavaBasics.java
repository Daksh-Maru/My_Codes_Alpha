import java.util.*;

public class JavaBasics {

        //To print fibonnaci series 
        
   public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int b = 1, a = 0;
        System.out.println(0 + " ");
        if (n > 1) {
            for (int i=1; i<=n; i++) {
                System.out.print(b + " ");
                int temp = b;
                b = b+a;
                a = temp;
            }
        }
   }
}