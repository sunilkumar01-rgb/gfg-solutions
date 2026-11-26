import java.util.ArrayList;

class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> ans = new ArrayList<>();
        // Minimum 4 digits (0.0.0.0) aur max 12 digits (255.255.255.255) chahiye
        if (s.length() < 4 || s.length() > 12) return ans;

        backtrack(s, 0, 0, "", ans);
        return ans;
    }

    private void backtrack(String s, int index, int dots, String current, ArrayList<String> ans) {
        // Jab 3 dots lag jayein, toh aakhri part bachega
        if (dots == 3) {
            String lastPart = s.substring(index);
            // Check karo ki aakhri part valid hai ya nahi
            if (isValid(lastPart)) {
                ans.add(current + lastPart);
            }
            return;
        }

        // Ek part me 1 se 3 character tak ho sakte hain
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            if (isValid(part)) {
                // Part valid hai, toh dot lagakar aage badho
                backtrack(s, index + i, dots + 1, current + part + ".", ans);
            }
        }
    }

    private boolean isValid(String part) {
        // Empty string check (Runtime Error se bachne ke liye)
        if (part.length() == 0) return false;

        // Leading zero allowed nahi hai (jaise "01" ya "00")
        if (part.length() > 1 && part.charAt(0) == '0') return false;

        // Value 0 se 255 ke beech honi chahiye
        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
}
