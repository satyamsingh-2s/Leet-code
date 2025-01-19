class Solution {
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public String fractionAddition(String e) {
        int ne = 0, de = 1,n = e.length(), i = 0;
        while (i < n) {
            int sign = e.charAt(i) == '-' ? -1 : 1;
            int num = 0, den = 0;
            i=(e.charAt(i) == '-' || e.charAt(i) == '+')?i+1:i;
            while (i < n && e.charAt(i) >= '0' && e.charAt(i) <= '9') 
                num = num * 10 + (e.charAt(i++) - '0');
            num *= sign;
            i++;
            while (i < n && e.charAt(i) >= '0' && e.charAt(i) <= '9') 
                den = den * 10 + (e.charAt(i++) - '0');
            ne = ne * den + num * de;
            de *= den;
            int gcd = gcd(Math.abs(ne), de);
            ne /= gcd;
            de /= gcd;
        }
        return ne == 0 ? "0/1" : ne + "/" + de;
    }
}