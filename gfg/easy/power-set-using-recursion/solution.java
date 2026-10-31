class Solution {
    public ArrayList<String> powerSet(String s) {

        ArrayList<String> result = new ArrayList<>();

        int n = s.length();

        int total = 1 << n;

        for (int i = 0; i < total; i++) {

            StringBuilder sub = new StringBuilder();

            for (int j = 0; j < n; j++) {

                if ((i & (1 << j)) != 0) {
                    sub.append(s.charAt(j));
                }
            }

            result.add(sub.toString());
        }

        Collections.sort(result);

        return result;
    }
}