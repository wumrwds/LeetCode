package top.wumrwds;


import java.util.*;

/**
 * 216. Combination Sum III
 *
 * @author wumrwds
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        helper(n, k, 9, new ArrayList<>(), result);

        return result;
    }

    private static void helper(int n, int k, int idx, List<Integer> combination, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            List<Integer> combinationPar = new LinkedList<>();
            for (int i = combination.size() - 1; i >= 0; i--) {
                combinationPar.add(combination.get(i));
            }
            result.add(combinationPar);
        }

        for (int i = idx; i > 0; i--) {
            if (i > n) {
                continue;
            }

            // if the target is less than i or no enough candidates or elements remained can't sum up to n, end loop
            if (i < k || (2 * i - k + 1) * k / 2 < n) {
                break;
            }

            combination.add(i);
            helper(n - i, k - 1, i - 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.combinationSum3(4, 1000));
        System.out.println(solution.combinationSum3(3, 9));
        System.out.println(solution.combinationSum3(4, 45));
        System.out.println(solution.combinationSum3(5, 45));
        System.out.println(solution.combinationSum3(1, 10));
        System.out.println(solution.combinationSum3(9, 3));
        System.out.println(solution.combinationSum3(6, 33));
    }
}