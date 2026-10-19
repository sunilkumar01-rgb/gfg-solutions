class Solution {
    public List<Integer> primeRange(int l, int r) {
        List<Integer> ans = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (isPrime(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}