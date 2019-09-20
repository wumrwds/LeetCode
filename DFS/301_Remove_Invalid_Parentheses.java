package top.wumrwds;


import java.util.LinkedList;
import java.util.List;

/**
 * 301. Remove Invalid Parentheses
 *
 * Time complexity: O(n^(k+1))   k is the amount of parentheses needed to be deleted
 *
 * @author wumrwds
 */
public class Solution {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new LinkedList<>();

        // Gets the amount of parentheses required for deletion     -- O(n)
        int[] dropCnt = getDropCnt(s);

        // if there's no need for deletion
        if (dropCnt[0] == 0 && dropCnt[1] == 0) {
            results.add(s);
            return results;
        }

        // dfs; the depth of dfs is controlled by the count calculated before
        // -- O(n^k * n)   |   n^k -> dfs iteration times   |   n  -> copy s
        dfs(s, 0, dropCnt[0], dropCnt[1], results);

        return results;
    }

    /**
     * Counts the amount of parentheses required for deletion.
     *
     * @param s
     * @return
     */
    private int[] getDropCnt(String s) {
        int[] dropCnt = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == OPEN) {
                dropCnt[0]++;
            }
            else if (ch == CLOSE) {
                if (dropCnt[0] > 0) {
                    dropCnt[0]--;
                }
                else {
                    dropCnt[1]++;
                }
            }
        }

        return dropCnt;
    }

    /**
     * Checks whether a string contains valid parentheses.
     *
     * @param s
     * @return
     */
    private boolean isValid(String s) {
        int[] dropCnt = getDropCnt(s);
        return dropCnt[0] == 0 && dropCnt[1] == 0;
    }

    /**
     * DFS
     *
     * @param s
     * @param idx
     * @param dropOpenCnt
     * @param dropCloseCnt
     * @param results
     */
    private void dfs(String s, int idx, int dropOpenCnt, int dropCloseCnt, List<String> results) {
        if (dropOpenCnt == 0 && dropCloseCnt == 0 && isValid(s)) {
            results.add(s);
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);

            // skip duplicates
            if (i > idx && ch == s.charAt(i-1)) {
                continue;
            }

            // note that here idx starts from i, since the previous i-th element is removed; i+1 - 1 = i
            if (ch == OPEN && dropOpenCnt > 0) {
                dfs(s.substring(0, i) + s.substring(i+1), i, dropOpenCnt-1, dropCloseCnt, results);
            }

            if (ch == CLOSE && dropCloseCnt > 0) {
                dfs(s.substring(0, i) + s.substring(i+1), i, dropOpenCnt, dropCloseCnt-1, results);
            }
        }
    }

    public static void main(String[] args) {
//        int nums[] = new int[] {1,2,3,4};
        System.out.println(new Solution().removeInvalidParentheses("()())()"));
        System.out.println(new Solution().removeInvalidParentheses("(a)())()"));
        System.out.println(new Solution().removeInvalidParentheses(")("));
        System.out.println(new Solution().removeInvalidParentheses(""));
        System.out.println(new Solution().removeInvalidParentheses("()"));
    }
}