class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        n = len(word)
        if numFriends == 1:
            return word  # whole word itself

        max_part_len = n - numFriends + 1  # max length a part can have
        max_str = ""

        for i in range(n - max_part_len + 1):
            # candidate substring of max_part_len starting at i
            part = word[i:i + max_part_len]
            if part > max_str:
                max_str = part

        # Also check suffixes that are shorter than max_part_len near the end
        for i in range(n - max_part_len + 1, n):
            part = word[i:n]  # shorter suffixes
            if part > max_str:
                max_str = part

        return max_str



        