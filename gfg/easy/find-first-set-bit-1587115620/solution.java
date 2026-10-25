class Solution {
    public static int getFirstSetBit(int n) {
        if (n == 0) return 0;

        int pos = 1;
        while ((n & 1) == 0) {
            n = n >> 1;
            pos++;
        }
        return pos;
    }
}