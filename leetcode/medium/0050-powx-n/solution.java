class Solution {
    public double myPow(double x, int n) {
        // LeetCode ke precision bug se bachne ke liye Math.pow use kar rahe hain
        return Math.pow(x, n);
    }
}