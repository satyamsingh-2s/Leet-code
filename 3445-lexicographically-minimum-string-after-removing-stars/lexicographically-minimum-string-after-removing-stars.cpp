class Solution {
public:
    string clearStars(string s) {
        priority_queue<char,vector<char>,greater<>> heap;
        vector<bool> removed(s.size(), false);
        unordered_map<char,stack<int>> um;

        for(int i=0;i<s.size();i++){
            if(s[i] == '*'){
                // peek at top character
                char peek = heap.top();
                heap.pop();

                // fetch last index
                int last_ind = um[peek].top();
                um[peek].pop();

                // mark that ind to be removed
                removed[last_ind] = true;
            }
            else{
                char ch = s[i];

                heap.push(ch);
                um[ch].push(i);
            }
        }

        // same approach to build string
        string ans = "";
        for(int i=0;i<s.size();i++){
            if(s[i]!='*' and removed[i]==false){
                ans += s[i];
            }
        }
        return ans;
    }
};