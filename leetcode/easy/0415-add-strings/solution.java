class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int a = 0;
            int b = 0;

            if (i >= 0) {
                a = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                b = num2.charAt(j) - '0';
                j--;
            }

            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}