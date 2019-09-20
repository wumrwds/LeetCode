package top.wumrwds;


import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * Using slide window to solve.
 *  1. Use two pointers: start and end to represent a window.
 *  2. Move end to find a valid window.
 *  3. When a valid window is found, move start to find a smaller window.
 *
 *
 * @author wumrwds
 */
public class Solution {

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }

        int tCnt = t.length(), minLen = Integer.MAX_VALUE, minStart = 0;
        int start, end;
        start = end = 0;
        while (end < s.length()) {
            // cntMap[endChar]--
            char endChar = s.charAt(end);
            int endCharCnt = cntMap.getOrDefault(endChar, 0);
            if (endCharCnt > 0) {
                // if endChar is a character in string t
                tCnt--;
            }
            cntMap.put(endChar, endCharCnt - 1);

            // if it is a valid substring
            while (tCnt == 0) {
                char startChar = s.charAt(start);
                Integer startCharCnt = cntMap.get(startChar);

                // save the min substring
                if (end - start < minLen && startCharCnt >= 0) {
                    minLen = end - start;
                    minStart = start;
                }

                // cntMap[startChar]++
                cntMap.put(startChar, startCharCnt + 1);

                if (startCharCnt + 1 > 0) {
                    // if startChar is a character in string t
                    tCnt++;
                }

                start++;
            }

            end++;
        }

        // if there's no valid substring, return ""
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen + 1);
    }

    public static void main(String[] args) {
//        int nums[] = new int[] {1,2,3,4};
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("SADQWERSXCANMWOQIENOIQNXAMVNCJKLWAEFR", "WQA"));
        System.out.println(new Solution().minWindow("MNQIOENIBNCIYGVWJNRPL:MNSCAFG#EMQMDLMSAFCD", ":DFQ"));
        System.out.println(new Solution().minWindow("", ":DFQ"));
        System.out.println(new Solution().minWindow("", ""));
        System.out.println(new Solution().minWindow(null, ""));

    }
}