class Solution {
    String modify(String s) {
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (vowels.indexOf(chars[left]) == -1) {
                left++;
            } else if (vowels.indexOf(chars[right]) == -1) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}