import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> mp = new HashMap<>(); // Stores frequency of each number
        Map<Integer, int[]> pairs = new HashMap<>(); // Stores {max frequency so far, dominant element} for each index
        int maxi = 0, ele = 0; // maxi = max frequency so far, ele = dominant element
        int n = nums.size() - 1; // Last index of the array

        // **Step 1: Compute prefix frequency data**
        for (int i = 0; i < nums.size(); i++) {
            mp.put(nums.get(i), mp.getOrDefault(nums.get(i), 0) + 1); // Update frequency
            
            // Update dominant element if the current number has a higher frequency
            if (mp.get(nums.get(i)) > maxi) {
                ele = nums.get(i); // Update dominant element
                maxi = mp.get(nums.get(i)); // Update max frequency
            }

            // Store the max frequency and dominant element at index `i`
            pairs.put(i, new int[]{maxi, ele});
        }

        // **Step 2: Find the minimum index for valid split**
        for (int i = 0; i < nums.size() - 1; i++) {
            int farr = (i + 1) / 2; // Required frequency for first part
            int sarr = (n - i) / 2; // Required frequency for second part

            int freq1 = pairs.get(i)[0]; // Frequency of dominant element in the first part
            int freq2 = pairs.get(n)[0] - freq1; // Frequency in second part

            // Check if dominant element remains dominant in both parts
            if (freq1 > farr && freq2 > sarr && pairs.get(i)[1] == pairs.get(n)[1]) {
                return i; // Return valid split index
            }
        }

        return -1; // If no valid split is found, return -1
    }
}