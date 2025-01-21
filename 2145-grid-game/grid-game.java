class Solution {
    long sum1=0;
    long sum2=0;
    public long gridGame(int[][] grid) {
        for(int i=0;i<grid[1].length;i++){
            sum1=sum1+grid[0][i];
        }
        long temp=sum1;
        for(int i=0;i<grid[0].length;i++){
            sum1=sum1-grid[0][i];
            sum2=sum2+grid[1][i];
            if(sum2>=sum1){
                sum2=sum2-grid[1][i];
                if(sum1>=sum2){
                    return sum1;
                }
                else return sum2;
            }
        }
        return sum1;
    }
}