class Solution {
    public boolean canWinNim(int n) {
        // Agar n, 4 ka multiple hai to aap kabhi nahi jeet sakte (optimal play me)
        return n % 4 != 0;
    }
}