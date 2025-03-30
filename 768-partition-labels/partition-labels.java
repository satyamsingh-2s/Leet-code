class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Store the last occurrence of each character
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            lastOccurrence.put(s.charAt(index), index);
        }

        List<Integer> partitionSizes = new ArrayList<>();
        int partitionStart = 0, partitionEnd = 0;

        // Step 2: Iterate and determine partitions
        for (int index = 0; index < s.length(); index++) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence.get(s.charAt(index)));
            if (index == partitionEnd) {
                partitionSizes.add(partitionEnd - partitionStart + 1);
                partitionStart = index + 1;
            }
        }
        return partitionSizes;
    }
}