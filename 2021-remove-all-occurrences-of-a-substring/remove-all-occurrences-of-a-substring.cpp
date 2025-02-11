class Solution {
public:
    string removeOccurrences(string& s, string& part) {
        string stack="";
        int tz=0, pz=part.size();
        for (char c: s){
            stack.push_back(c);
            tz++;
            if (tz>=pz && stack.ends_with(part)){
                tz-=pz;
                stack.resize(tz);
            }
        }
        return stack;
        
    }
};