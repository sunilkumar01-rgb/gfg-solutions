class Sol {
    int[] count(String s) {
        int upper = 0;
        int lower = 0;
        int digit = 0;
        int special = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                upper++;
            } else if (ch >= 'a' && ch <= 'z') {
                lower++;
            } else if (ch >= '0' && ch <= '9') {
                digit++;
            } else {
                special++;
            }
        }

        return new int[]{upper, lower, digit, special};
    }
}