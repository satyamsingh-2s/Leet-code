class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long[] hidden = new long[differences.length+1];
        hidden[0] = 0;
        for(int i = 1;i<hidden.length;i++){
            hidden[i] = hidden[i-1] + differences[i-1];
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int i = 0;i<hidden.length;i++){
            if(hidden[i]<min) min = hidden[i];
            if(hidden[i]>max) max = hidden[i];
        }
        if(max-min > upper-lower) return 0;
        return ((upper-lower)-(int)(max-min)+1);
    }
}