class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        if numFriends == 1:
            return word

        leng = len(word) - numFriends + 1
        res = ''
        l, r = 0, leng -1
        
        while l < len(word):
            if word[l:r + 1] > res:
                res = word[l:r + 1]
            l += 1
            r += 1

        return res