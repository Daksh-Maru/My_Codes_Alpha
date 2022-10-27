import java.util.*;

public class StockSpanP {
    public static void stockSpan(int[] Stocks, int[] Span) {
        Stack<Integer> s = new Stack<>();
        Span[0] = 1;
        s.push(0);
        for (int i=1; i<Stocks.length; i++) {
            int currP = Stocks[i];
            while (!s.isEmpty() && currP > Stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                Span[i] = i+1;
            }   
            else { 
                Span[i] = i - s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int[] Stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] Span = new int[Stocks.length];
        stockSpan(Stocks, Span);
        for (int i=0; i<Span.length; i++) {
            System.out.print(Span[i] + " ");
        }
    }
}