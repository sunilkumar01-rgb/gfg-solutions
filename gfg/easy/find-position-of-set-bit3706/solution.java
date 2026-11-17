class Solution {
    static int findPosition(int N) {
        // Agar N 0 hai, ya N me ek se zyada set bits hain
        if (N == 0 || (N & (N - 1)) != 0) {
            return -1;
        }

        int pos = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                return pos;
            }
            N >>= 1;
            pos++;
        }
        return -1;
    }
}