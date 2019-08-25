/** 其实不用去排序，每次去比较每个str的第i个字符就好了
 *  共四种方法:
 *     ① 直接扫描判断
 *     ② 分治法
 *     ③ 垂直扫描判断
 *     ④ trie
 */
class Solution {
public:
    static bool compare(string a, string b){
        return a.length() < b.length();
    }

    int prefixLen(string a, string b){
        int len = 0;
        while(len < a.length() && a[len] == b[len]) len++;
        return len;
    }

    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0)    return "";
        sort(strs.begin(), strs.end(), compare);
        string pre = strs[0];
        for(int i = 1; i < strs.size(); i++){
            int tmpLen = prefixLen(pre, strs[i]);
            pre = pre.substr(0, tmpLen);
        }
        return pre;
    }
};
