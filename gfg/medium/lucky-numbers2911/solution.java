class Solution {
    public static boolean isLucky(int n) {
        return isLuckyHelper(n, 2);
    }

    private static boolean isLuckyHelper(int n, int counter) {
        if (counter > n) return true;
        if (n % counter == 0) return false;

        // After removing elements, the position shifts
        return isLuckyHelper(n - (n / counter), counter + 1);
    }
}