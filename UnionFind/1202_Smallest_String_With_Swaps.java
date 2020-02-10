package top.wumrwds;


import java.util.*;

/**
 * 1202. Smallest String With Swaps
 *
 * @author wumrwds
 */
public class Solution {

    public class DisjointSet {

        private int[] ranks;
        private int[] parents;

        /**
         * Makes sets.
         *
         * @param n
         */
        DisjointSet(int n) {
            ranks = new int[n];
            parents = new int[n];

            for (int i = 0; i < n; i++) {
                ranks[i] = 1;
                parents[i] = i;
            }
        }

        /**
         * Finds set representative with path compression.
         *
         * @param x
         * @return
         */
        private int findSet(int x) {
            if (parents[x] != x) {
                parents[x] = findSet(parents[x]);
            }
            return parents[x];
        }

        /**
         * Links two sets.
         *
         * @param p1
         * @param p2
         */
        private void link(int p1, int p2) {
            if (ranks[p1] < ranks[p2]) {
                // set1 is less than set2
                // make p2 the parent(root) of p1
                parents[p1] = p2;
            }
            else {
                // set1 is larger than set2
                // make p1 the parent(root) of p2
                parents[p2] = p1;

                // set1 is as the same rank as set2
                // increase the rank of the root p1
                if (ranks[p1] == ranks[p2]) {
                    ranks[p1]++;
                }
            }
        }

        public void union(int x, int y) {
            link(findSet(x), findSet(y));
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();

        // generate the disjointSet data structure
        DisjointSet disjointSet = new DisjointSet(n);
        for (List<Integer> pair : pairs) {
            disjointSet.union(pair.get(0), pair.get(1));
        }

        // distribute each character into its group
        Map<Integer, List<Character>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int group = disjointSet.findSet(i);

            // use linkedList as a queue here; Java use merged sort for sorting linked list, so there's no need to
            // worry about the performance
            List<Character> characters = groups.computeIfAbsent(group, (dummy) -> new LinkedList<>());
            characters.add(s.charAt(i));
        }

        // sort all characters within a group
        for (List<Character> characters : groups.values()) {
            Collections.sort(characters);
        }

        // iterate each indices, and append the head letter of the current group
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            List<Character> characters = groups.get(disjointSet.findSet(i));
            Character head = characters.remove(0);
            ans.append(head);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Solution().smallestStringWithSwaps("dcab", arrayToList(new int[][]{{0,3},{1,2}})));
        System.out.println(new Solution().smallestStringWithSwaps("dcab", arrayToList(new int[][]{{0,3},{1,2},{0,2}})));
        System.out.println(new Solution().smallestStringWithSwaps("cba",  arrayToList(new int[][]{{0,1},{1,2}})));
        System.out.println(new Solution().smallestStringWithSwaps("qdwyt", arrayToList(new int[][]{{2, 3}, {3, 2}, {0, 1}, {4, 0}, {3, 2}})));
        System.out.println(new Solution().smallestStringWithSwaps("udyyek", arrayToList(new int[][]{{3, 3}, {3, 0}, {5, 1}, {3, 1}, {3, 4}, {3, 5}})));
    }

    private static List<List<Integer>> arrayToList(int[][] pairs) {
        List<List<Integer>> pairsList = new ArrayList<>();
        for (int[] pair : pairs) {
            List<Integer> pairList = new ArrayList<>();
            pairList.add(pair[0]);
            pairList.add(pair[1]);
            pairsList.add(pairList);
        }

        return pairsList;
    }
}