class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long MOD = 1_000_000_007;
        long lcm = (long) a / gcd(a, b) * b;
        
        long left = Math.min(a, b);
        long right = (long) n * Math.min(a, b);
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b - mid / lcm;
            
            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) (left % MOD);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}