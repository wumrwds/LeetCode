class Solution {
    private Random random = new Random();
    
    public int[][] kClosest(int[][] points, int K) {
        
        helpSort(points, 0, points.length - 1, K - 1);
        
        return Arrays.copyOfRange(points, 0, Math.min(K, points.length));
    }
    
    private void helpSort(int[][] points, int p, int q, int k) {
        if (p < q) {
            int idx = partition(points, p, q);

            if (idx < k) {
                helpSort(points, p, idx - 1, k);
                helpSort(points, idx + 1, q, k);
            }
            else {
                helpSort(points, p, idx - 1, k);
            }
        }
    }
    
    private int partition(int[][] points, int p, int q) {
        // randomly select the pivot element
        int r = ThreadLocalRandom.current().nextInt(p, q);
        int pivotDist = distance(points[r]);
        swap(points, r, q);
        
        // partition the array into two parts
        int i = p - 1;
        for (int j = p; j < q; j++) {
            if (distance(points[j]) < pivotDist) {
                i++;
                swap(points, i, j);
            }
        }
        
        // swap the pivot into its place
        swap(points, i+1, q);
        
        return i+1;
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int tmp0 = points[i][0], tmp1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = tmp0;
        points[j][1] = tmp1;
    }
}