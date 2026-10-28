class Solution {
    public List<String> pascalCase(String[] arr, String pat) {
        List<String> ans = new ArrayList<>();

        for (String word : arr) {
            StringBuilder sb = new StringBuilder();

            // Word me se saare Uppercase letters nikaalo
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(c);
                }
            }

            // Agar uppercase letters pattern se start hote hain, to add karo
            if (sb.toString().startsWith(pat)) {
                ans.add(word);
            }
        }

        return ans;
    }
}