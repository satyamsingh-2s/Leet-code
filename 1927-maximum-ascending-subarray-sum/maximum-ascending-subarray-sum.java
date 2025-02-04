class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0], curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = (nums[i] > nums[i - 1]) ? curSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
    }
}
