import java.util.*;

class Solution {
    public ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        char[] arr = s.toCharArray();
        generate(arr, 0, result);

        Collections.sort(result);
        return result;
    }

    private void generate(char[] arr, int index,
                          ArrayList<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);

            generate(arr, index + 1, result);

            swap(arr, index, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}