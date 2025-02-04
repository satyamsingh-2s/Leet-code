class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; // Initialize max sum
        int curSum = nums[0]; // Start first subarray sum
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) { // If ascending, add to current sum
                curSum += nums[i];
            } else { // If not ascending, reset current sum
                maxSum = Math.max(maxSum, curSum);
                curSum = nums[i]; // Start new subarray sum
            }
        }
        
        // Compare maxSum with the last computed curSum before returning
        return Math.max(maxSum, curSum);
    }
}
