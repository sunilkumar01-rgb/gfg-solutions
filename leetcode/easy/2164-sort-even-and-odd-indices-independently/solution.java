class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n= nums.length;
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i%2==1){
                odd.add(nums[i]);
            }
        else{
            even.add(nums[i]);
        }
        }
        Collections.sort(even);
        Collections.sort(odd,Collections.reverseOrder());

        int e=0;
        int o=0;
        for(int i=0;i<n;i++){
            if(i%2==1){
                nums[i]=odd.get(o);
                o++;
            }
            else{
                nums[i]=even.get(e);
                e++;
            }
        }
        return nums;
    }

}