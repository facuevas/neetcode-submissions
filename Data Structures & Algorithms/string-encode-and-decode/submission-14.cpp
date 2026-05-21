class Solution {
public:
    // Format - length#actualstring
    string encode(vector<string>& strs) {
        ostringstream oss;
        for (const auto& str : strs) {
            oss << str.size() << '#' << str;
        }
        return oss.str();
    }

    vector<string> decode(string s) {
        vector<string> res;
        int i = 0;
        while (i < s.size()) {
            size_t hashPos = s.find('#', i);
            int len = stoi(s.substr(i, hashPos - i));
            i = hashPos + 1;
            res.push_back(s.substr(i, len));
            i += len;
        }
        return res;
    }
};
