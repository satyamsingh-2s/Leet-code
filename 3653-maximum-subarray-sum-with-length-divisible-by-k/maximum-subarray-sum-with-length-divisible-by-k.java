class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE / 2);
        minPref[k - 1] = 0;
        
        long sum = 0, res = Long.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = i % k;
            res = Math.max(res, sum - minPref[r]);
            minPref[r] = Math.min(minPref[r], sum);
        }
        
        return res;
    }
}