class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0;     // Max profit if we just sold today
        int held = Integer.MIN_VALUE; // Max profit if we hold a stock
        int rest = 0;     // Max profit if we are in cooldown/rest
        
        for (int price : prices) {
            int prevSold = sold;
            
            // Aaj bechne par profit: kal tak hold kiya hua tha + aaj ka price
            sold = held + price;
            
            // Aaj hold karne par: ya toh kal se hold kar rahe the, ya aaj rest ke baad kharida
            held = Math.max(held, rest - price);
            
            // Aaj rest karne par: ya toh kal sold kiya tha (cooldown), ya kal se rest kar rahe the
            rest = Math.max(rest, prevSold);
        }
        
        return Math.max(sold, rest);
    }
}