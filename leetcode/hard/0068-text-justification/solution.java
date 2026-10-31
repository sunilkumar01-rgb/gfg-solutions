class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int j = i + 1;
            int lineLength = words[i].length();
            
            // Find how many words fit in this line
            while (j < words.length && lineLength + words[j].length() + (j - i - 1) < maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            int diff = maxWidth - lineLength;
            int numOfWords = j - i;
            
            // If last line or only 1 word, left justify
            if (j == words.length || numOfWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                // Fully justify
                int spaces = diff / (numOfWords - 1);
                int extraSpaces = diff % (numOfWords - 1);
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s <= spaces + (k - i < extraSpaces ? 1 : 0) - 1; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            ans.add(sb.toString());
            i = j;
        }
        return ans;
    }
}