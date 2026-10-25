class Solution {
    public ArrayList<String> generateGrayCodes(int n) {
        ArrayList<String> result = new ArrayList<>();
        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);
            result.add(String.format("%" + n + "s",
                    Integer.toBinaryString(gray)).replace(' ', '0'));
        }

        return result;
    }
}