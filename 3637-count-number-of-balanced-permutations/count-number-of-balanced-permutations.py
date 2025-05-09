class Solution:
    def countBalancedPermutations(self, num: str) -> int:
        MOD = 10**9 + 7
        n = len(num)
        cnt = [0] * 10
        s = 0
        for c in num:
            d = int(c)
            cnt[d] += 1
            s += d
        if s % 2 != 0:
            return 0
        target = s // 2
        
        # Precompute binomial coefficients
        MX = n + 1
        c = [[0] * MX for _ in range(MX)]
        for i in range(MX):
            c[i][0] = 1
            for j in range(1, i + 1):
                c[i][j] = (c[i-1][j] + c[i-1][j-1]) % MOD
        
        # DFS function with memoization
        @cache
        def dfs(i: int, j: int, a: int, b: int) -> int:
            if i > 9:
                return 1 if j == 0 and a == 0 and b == 0 else 0
            if a == 0 and j > 0:
                return 0
            ans = 0
            for l in range(min(cnt[i], a) + 1):
                r = cnt[i] - l
                if r < 0 or r > b:
                    continue
                if l * i > j:
                    continue
                t = (c[a][l] * c[b][r]) % MOD
                t = (t * dfs(i + 1, j - l * i, a - l, b - r)) % MOD
                ans = (ans + t) % MOD
            return ans
        
        # Initial call
        return dfs(0, target, n // 2, (n + 1) // 2)