class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int i = len%2 ==0 ? len/2 -1 : len/2;
        long firstHalf = Long.parseLong(n.substring(0, i+1));

        List<Long> p = new ArrayList<>();

        p.add(halfTo(firstHalf, len%2 == 0));
        p.add(halfTo(firstHalf+1, len%2 == 0));
        p.add(halfTo(firstHalf-1, len%2 == 0));
        p.add((long) Math.pow(10, len-1)-1);
        p.add((long) Math.pow(10, len)+1);

        long diff = Long.MAX_VALUE, res=0, n1 = Long.parseLong(n);
        for(long cand : p){
            if(cand==n1) continue;
            if(Math.abs(cand-n1)<diff){
                diff= Math.abs(cand-n1);
                res=cand;
            }else if(Math.abs(cand-n1)==diff){
                res=Math.min(res,cand);
            }
        }
        return String.valueOf(res);

    }

    private long halfTo(long left, boolean even){
        long res = left;
        if(!even) left /=10;
        while(left>0){
            res = res*10+(left%10);
            left/=10;
        }
        return res;
    }
}