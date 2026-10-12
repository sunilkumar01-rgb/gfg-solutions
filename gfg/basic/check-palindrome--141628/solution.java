class Solution {
    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            if (l != r) return false;

            left++;
            right--;
        }

        return true;
    }
}