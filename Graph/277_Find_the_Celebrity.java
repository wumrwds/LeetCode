/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int celebrity = 0;
            for (int i = 1; i < n; i++) {
                if (knows(celebrity, i)) {
                    celebrity = i;
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) {
                    return -1;
                }
            }
            
            return celebrity;
        }

        public int findCelebrity2(int n) {
            int[] degree = new int[n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    
                    if (knows(i, j)) {
                        degree[i]--;
                        degree[j]++;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (degree[i] == n-1) {
                    return i;
                }
            }
            
            return -1;
        }
    }