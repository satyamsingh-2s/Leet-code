class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        int size = matrix.size();

        long long Sum = 0;
        int neg_Cnt = 0;
        int small_Abs = INT_MAX;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Sum += abs(matrix[i][j]);

                if(matrix[i][j] < 0)
                    neg_Cnt++;

                small_Abs = min(small_Abs, abs(matrix[i][j]));
            }
        }

        if(neg_Cnt % 2 == 0)
            return Sum;

        return Sum - 2 * small_Abs;
    }
};