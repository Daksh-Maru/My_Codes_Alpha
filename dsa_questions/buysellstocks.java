import java.util.*;
    public class buysellstocks {
        //1st method 
        public static int maxProfitinStocks (int prices[]) {       
            int buyPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i=0; i<prices.length; i++) {
                if (buyPrice < prices[i]) {
                    int profit = prices[i] - buyPrice;
                    maxProfit = Math.max(profit, maxProfit);
                }
                else {
                    buyPrice = prices[i];
                }
            }
            return maxProfit;
        }
        //2nd method
        public static int maxProfitinStocks (int prices[], int n) {
            int buy = prices[0];
            int profit = 0;
            for (int i=1; i<n; i++) {
                if (prices[i] < buy) {
                    buy = prices[i];
                } 
                else if (prices[i] - buy > profit) {
                    profit = prices[i] - buy;
                }
            }
            return profit;
        }
        public static void main(String args[]) {
            int prices[] = {7, 1, 5, 3, 6, 4};
            int n = prices.length;
            System.out.println(maxProfitinStocks(prices));
        }
    }