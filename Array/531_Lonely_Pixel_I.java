class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        boolean[] rowOccur = new boolean[m], colOccur = new boolean[n];
        int[] rowCnt = new int[m], colCnt = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    if (!rowOccur[i]) {
                        rowCnt[i]++;
                        rowOccur[i] = true;
                    }
                    else {
                        rowCnt[i]--;
                    }

                    if (!colOccur[j]) {
                        colCnt[j]++;
                        colOccur[j] = true;
                    }
                    else {
                        colCnt[j]--;
                    }
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowCnt[i] == 1 && colCnt[j] == 1 && picture[i][j] == 'B') {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}