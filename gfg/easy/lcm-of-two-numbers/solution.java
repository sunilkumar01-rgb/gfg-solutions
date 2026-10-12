class Solution {
    static int lcm(int a, int b) {
        int x = a, y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;
        return (a / gcd) * b;
    }
}