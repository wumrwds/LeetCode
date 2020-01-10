class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> cntMap = new HashMap<>();
        for (String pair : cpdomains) {
            int spaceIdx = pair.indexOf(" ");
            int count = Integer.parseInt(pair.substring(0, spaceIdx));
            String url = pair.substring(spaceIdx + 1);
            
            int periodIdx = 0;
            while (periodIdx >= 0) {
                cntMap.put(url, cntMap.getOrDefault(url, 0) + count);
                periodIdx = url.indexOf(".");
                url = url.substring(periodIdx + 1);
            }
        }
        
        List<String> ans = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        
        return ans;
    }
}