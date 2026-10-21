class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        if (n < 3) return false;

        // 1. Array ko sort karo
        Arrays.sort(arr);

        // 2. Har element ko fix karke baaki 2 elements Two Pointers se dhundho
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    return true; // Match mil gaya
                } else if (currentSum < target) {
                    left++; // Sum chhota hai, toh bada element chahiye
                } else {
                    right--; 
                }
            }
        }

        return false; // Koi triplet nahi mila
    }
}