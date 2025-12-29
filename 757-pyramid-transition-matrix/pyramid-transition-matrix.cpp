class Solution {
    // Map to store allowed transitions
    // Key: pair of characters (length 2)
    // Value: list of possible characters on top
    unordered_map<string, vector<char>> mpp;

public:
    // DFS function to try building pyramid
    // bot -> current bottom row
    // i   -> current index in bot
    // tem -> temporary string for next row
    bool dfs(string bot, int i, string tem) {
        
        // Base case: pyramid successfully built
        if (bot.size() == 1) 
            return true;

        // If we finished building the next row
        if (i == bot.size() - 1) {
            string nextRow;
            return dfs(tem, 0, nextRow);
        }

        // Take current adjacent pair
        string key = bot.substr(i, 2);

        // Try all possible characters that can go above this pair
        for (char v : mpp[key]) {
            tem.push_back(v);              // choose
            if (dfs(bot, i + 1, tem))      // explore
                return true;               // valid pyramid found
            tem.pop_back();                // backtrack
        }

        // No valid configuration found
        return false;
    }

    bool pyramidTransition(string bottom, vector<string>& allowed) {
        
        // Build the mapping from allowed transitions
        for (auto &a : allowed) {
            mpp[a.substr(0, 2)].push_back(a[2]);
        }

        string temp;
        return dfs(bottom, 0, temp);
    }
};