class Solution {
    public String rankTeams(String[] votes) {
        int[][] cnt = new int[26][26];
        int n = votes[0].length();
        
        for (int i = 0; i < n; i++) {
            for (String vote : votes) {
                cnt[vote.charAt(i) - 'A'][i]++;
            }
        }
        
        List<Character> charList = new ArrayList(n);
        for (char ch : votes[0].toCharArray()) {
            charList.add(ch);
        }
        
        Collections.sort(charList, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (cnt[a-'A'][i] == cnt[b-'A'][i]) {
                    continue;
                }
                
                return cnt[b-'A'][i] - cnt[a-'A'][i];
            }
            
            return a - b;
        });
        
        StringBuilder res = new StringBuilder();
        for (Character ch : charList) {
            res.append(ch);
        }
        
        return res.toString();
    }
}