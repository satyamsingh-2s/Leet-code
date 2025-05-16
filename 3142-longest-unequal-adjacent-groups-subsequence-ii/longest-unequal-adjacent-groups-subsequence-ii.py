class Solution:
    def getWordsInLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
# --------------------------------------------------------------------
        # Solution 3:
# --------------------------------------------------------------------
        def pack(w: str) -> int:
            code = 0
            for i, ch in enumerate(w):
                code |= (ord(ch) - 97) << (5 * i)
            return code

        n = len(words)
        dp = [1] * n
        prev = [-1] * n
        max_len = 1
        max_idx = 0
        patterns_by_len = {}  # [L] → list of dicts per wildcard position
        codes = [pack(w) for w in words]  # Pre-pack all words
        for i, w in enumerate(words):
            L = len(w)
            g_i = groups[i]
            code_i = codes[i]
            # ensure buckets exist for this length
            buckets = patterns_by_len.setdefault(L,
                      [defaultdict(list) for _ in range(L)])
            best_len = 1
            best_prev = -1
            for j in range(L):          # Try each single-char wildcard mask
                mask = ~(31 << (5 * j))
                pat = code_i & mask
                for k in buckets[j].get(pat, ()):
                    if groups[k] != g_i and dp[k] + 1 > best_len:
                        best_len = dp[k] + 1
                        best_prev = k
            dp[i] = best_len
            prev[i] = best_prev
            for j in range(L):          # Register i w/ each of its L masks
                mask = ~(31 << (5 * j))
                pat = code_i & mask
                buckets[j].setdefault(pat, []).append(i)
            if best_len > max_len:
                max_len = best_len
                max_idx = i

        res = []
        cur = max_idx
        while cur != -1:              # Reconstruct subsequence
            res.append(words[cur])
            cur = prev[cur]
        return res[::-1]

# --------------------------------------------------------------------
#       Solution 2: Optimized for larger n
# --------------------------------------------------------------------
        n = len(words)
        if n == 0: return []
        dp, prev, patterns = [1] * n, [-1] * n, {} 
        max_len, max_idx = 1, 0
        for i, w in enumerate(words):
            best_len, best_prev = 1, -1
            g_i, L = groups[i], len(w)
            for j in range(L):
                patt = w[:j] + '*' + w[j+1:]
                for k in patterns.get(patt, ()):
                    if groups[k] != g_i and dp[k] + 1 > best_len:
                        best_len = dp[k] + 1
                        best_prev = k
            dp[i] = best_len
            prev[i] = best_prev
            for j in range(L):
                patt = w[:j] + '*' + w[j+1:]
                patterns.setdefault(patt, []).append(i)
            if best_len > max_len:
                max_len = best_len
                max_idx = i
        res, cur = [], max_idx
        while cur != -1:
            res.append(words[cur])
            cur = prev[cur]
        return res[::-1]

# --------------------------------------------------------------------
        # Solution 1:
# --------------------------------------------------------------------
        def hamming1(a, b):
            if len(a) != len(b):
                return False
            diff = 0
            for x, y in zip(a, b):
                if x != y:
                    diff += 1
                    if diff > 1:
                        return False
            return diff == 1
        
        n = len(words)
        dp = [1] * n
        prev = [-1] * n
        max_len = 1
        max_idx = 0    
        for i in range(n):
            for j in range(i):
                if groups[i] != groups[j] and hamming1(words[i], words[j]):
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        prev[i] = j
            if dp[i] > max_len:
                max_len = dp[i]
                max_idx = i
        seq = []
        cur = max_idx
        while cur != -1:
            seq.append(words[cur])
            cur = prev[cur]
        seq.reverse()
        return seq