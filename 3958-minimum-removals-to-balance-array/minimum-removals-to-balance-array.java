import java.util.*;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int l = 0;
        int max = 0;

        for (int r = 0; r < n; r++) {
            while (l < r && nums[r] > (long) nums[l] * k) {
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return n - max;
    }
}