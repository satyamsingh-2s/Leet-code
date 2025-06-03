import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] opened = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int totalCandies = 0;
        int boxesAvailable = 0; 

        for (int boxIndex : initialBoxes) {
            hasBox[boxIndex] = true;
            if (status[boxIndex] == 1) {
                q.offer(boxIndex);
            } else {
                boxesAvailable++; 
            }
        }

        while (!q.isEmpty()) {
            int boxIndex = q.poll();

            if (opened[boxIndex]) continue;

            opened[boxIndex] = true;
            totalCandies += candies[boxIndex];

            for (int key : keys[boxIndex]) {
                if (status[key] == 0) { 
                    status[key] = 1;
                    if (hasBox[key]) {
                        q.offer(key);
                        boxesAvailable--; 
                    }
                }
            }

            for (int containedBox : containedBoxes[boxIndex]) {
                if (!hasBox[containedBox]) { 
                    hasBox[containedBox] = true;
                    if (status[containedBox] == 1) {
                        q.offer(containedBox);
                    } else {
                        boxesAvailable++;
                    }
                }
            }

            if (q.isEmpty() && boxesAvailable > 0) {
                boolean canOpen = false;
                for (int i = 0; i < n; i++) {
                    if (hasBox[i] && !opened[i] && status[i] == 1) {
                        q.offer(i);
                        canOpen = true;
                        boxesAvailable--;
                    }
                }
                if (!canOpen) return totalCandies;
            }
        }

        return totalCandies;
    }
}