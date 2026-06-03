// algo -- run 2 loop -- time limit exceededd
// algo -- create a new array for mapping - not excepted as not allowed to create extra memory
// algo -- 

class Solution {
    public int findDuplicate(int[] nums) {
                int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int slow2 = nums[0];

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;        

        
    }
}