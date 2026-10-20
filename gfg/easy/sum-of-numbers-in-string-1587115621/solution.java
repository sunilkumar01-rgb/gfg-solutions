class Solution {
    public static long findSum(String str) {
        long sum = 0;
        long num = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                sum += num;
                num = 0;
            }
        }
        sum += num;
        return sum;
    }
}