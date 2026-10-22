
class Solution {
    public static int minIndexChar(String str, String patt) {
        boolean[] present = new boolean[Character.MAX_VALUE + 1];

        for (int i = 0; i < patt.length(); i++) {
            present[patt.charAt(i)] = true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (present[str.charAt(i)]) {
                return i;
            }
        }

        return -1;
    }
}
