
import java.util.*;

class Solution {
    public ArrayList<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int r = 0, c = 0, dir = 0;

        while (r >= 0 && r < n && c >= 0 && c < m) {
            if (mat[r][c] == 1) {
                mat[r][c] = 0;
                dir = (dir + 1) % 4;
            }

            if (dir == 0) {
                c++;
            } else if (dir == 1) {
                r++;
            } else if (dir == 2) {
                c--;
            } else {
                r--;
            }
        }

        if (dir == 0) c--;
        else if (dir == 1) r--;
        else if (dir == 2) c++;
        else r++;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(r);
        arr.add(c);

        return arr;
    }
}