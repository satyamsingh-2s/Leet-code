class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int res = -1;

        for(int i : nums){
            int digSum = getDigitSum(i);

            if(hash.containsKey(digSum)){
                res = Math.max(res, i + hash.get(digSum));

                hash.put(digSum, Math.max(i, hash.get(digSum)));
            } else {
                hash.put(digSum, i);
            }

        }
        return res;
    }
    public int getDigitSum(int n){
        int res = 0;
        while(n>0){
            res += n % 10;
            n /= 10;
        }        
        return res;
    }
}