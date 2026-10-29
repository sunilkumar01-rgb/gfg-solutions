class Solution {
    public static int countSetBits(int n) {
        if (n == 0) {
            return 0;
        }

        int x = 0;
        while ((1 << (x + 1)) <= n) {
            x++;
        }

        return (x * (1 << (x - 1)))
             + (n - (1 << x) + 1)
             + countSetBits(n - (1 << x));
    }
}