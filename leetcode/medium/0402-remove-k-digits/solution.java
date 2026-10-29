class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // Agar k bacha hai (jaise "1111" jaisa ascending case)
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Build string and remove leading zeros
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}