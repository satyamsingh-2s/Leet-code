import java.util.*;

class Solution {
    public int maximumInvitations(int[] favorite) {
        // Calculate the maximum invitations using two approaches and return the larger value
        return Math.max(findMaxCycle(favorite), calculateTopologicalSort(favorite));
    }

    // Method to find the maximum size of any cycle in the graph
    private int findMaxCycle(int[] favorite) {
        int n = favorite.length;
        boolean[] visited = new boolean[n];
        int maxCycleSize = 0;

        for (int i = 0; i < n; ++i) {
            // Skip if the node is already visited
            if (visited[i]) continue;

            List<Integer> cycle = new ArrayList<>();
            int current = i;

            // Traverse the graph to detect a cycle
            while (!visited[current]) {
                cycle.add(current);
                visited[current] = true;
                current = favorite[current];
            }

            // Calculate the cycle length
            for (int k = 0; k < cycle.size(); ++k) {
                if (cycle.get(k) == current) {
                    maxCycleSize = Math.max(maxCycleSize, cycle.size() - k);
                }
            }
        }

        return maxCycleSize;
    }

    // Method to calculate the sum of chain lengths from nodes that form mutual pairs
    private int calculateTopologicalSort(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        int[] chainLength = new int[n];
        Arrays.fill(chainLength, 1);

        // Calculate indegree of each node
        for (int node : favorite) {
            indegree[node]++;
        }

        // Perform topological sort using a queue
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            chainLength[favorite[current]] = Math.max(chainLength[favorite[current]], chainLength[current] + 1);

            if (--indegree[favorite[current]] == 0) {
                queue.offer(favorite[current]);
            }
        }

        // Sum the chain lengths for nodes involved in mutual pairs
        int totalChainLength = 0;
        for (int i = 0; i < n; ++i) {
            if (i == favorite[favorite[i]]) {
                totalChainLength += chainLength[i];
            }
        }

        return totalChainLength;
    }
}