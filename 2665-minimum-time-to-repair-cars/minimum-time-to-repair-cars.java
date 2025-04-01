class Solution {
    private long tot_cars(long min, int[] ranks) {
        long cnt = 0;
        for (int rank : ranks) {
            cnt += (long) Math.sqrt(min / rank);
        }
        return cnt;
    }

    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = (long) Arrays.stream(ranks).max().getAsInt() * cars * cars;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (tot_cars(mid, ranks) >= cars) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}