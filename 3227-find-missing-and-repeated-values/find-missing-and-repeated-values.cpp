class Solution {
public:
    static vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        const int n=grid.size(), n2=n*n;

        //precomputed sums
        const int sumN=n2*(n2+1)/2;  // sum([1...n^2])
        const long long sumCk_2N2=(n2-1LL)*n2*(n2+1)/3;  // Sum of 2*C(k,2)

        int sum=0;
        long long sumCk_2=0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int x=grid[i][j];
                sum+=x;
                sumCk_2+=x*(x-1);  // Add 2*C(x,2)
            }
        }

        int diff=sum-sumN;  // a-b
        int diff2=sumCk_2-sumCk_2N2+diff;  // a^2-b^2
        int sum2=diff2/diff;  // a+b

        return {(sum2+diff)/2, (sum2-diff)/2};
    }
};

 
auto init = []()
{ 
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    return 'c';
}();