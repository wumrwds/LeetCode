class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort people
        Arrays.sort(people, (people1, people2) -> {
            int heightDiff = people1[0] - people2[0];

            if (heightDiff == 0) {
                // sort by index
                return people1[1] - people2[1];
            }

            return -heightDiff;
        });

        List<int[]> result = new LinkedList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }

        return result.toArray(new int[0][0]);
    }
}