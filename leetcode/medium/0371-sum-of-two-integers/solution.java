class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // carry nikalna
            int carry = (a & b) << 1;
            // bina carry ke sum nikalna
            a = a ^ b;
            // carry ko next iteration ke liye bhejna
            b = carry;
        }
        return a;
    }
}