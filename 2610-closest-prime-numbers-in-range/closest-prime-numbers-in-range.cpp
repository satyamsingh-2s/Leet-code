class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        int n = right + 1;
        vector<bool> is_prime(n, true);
        is_prime[0] = is_prime[1] = false;

        // Implementing the sieve
        for (int i = 2; i <= sqrt(n); ++i) {
            if (is_prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    is_prime[j] = false;
                }
            }
        }

        // Collecting all primes in the range [left, right]
        vector<int> primes;
        for (int i = left; i <= right; ++i) {
            if (is_prime[i]) {
                primes.push_back(i);
            }
        }

        // If there are less than two primes, return [-1, -1]
        if (primes.size() < 2) {
            return {-1, -1};
        }

        // Finding the closest pair of primes
        int min_diff = INT_MAX;
        vector<int> closest_pair;

        for (size_t i = 1; i < primes.size(); ++i) {
            int diff = primes[i] - primes[i - 1];
            if (diff < min_diff) {
                min_diff = diff;
                closest_pair = {primes[i - 1], primes[i]};
            }
            if (min_diff == 1) {  // If the difference is 1, we've found the closest possible pair
                break;
            }
        }

        return closest_pair;
    }
};