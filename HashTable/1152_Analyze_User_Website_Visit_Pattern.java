class Solution {
    /*

    A special case:

    ["h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"]
    [527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930]
    ["hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"]


    {
    eiy=[Pair{website='hibympufi', timestamp=334462937}], 
    txldsscx=[Pair{website='hibympufi', timestamp=159548699}, Pair{website='hibympufi', timestamp=444082139}], 
    h=[Pair{website='hibympufi', timestamp=527896567}, Pair{website='hibympufi', timestamp=134127993}, Pair{website='yljmntrclw', timestamp=926837079}], 
    cq=[Pair{website='hibympufi', timestamp=517687281}, Pair{website='hibympufi', timestamp=859112386}, Pair{website='hibympufi', timestamp=51100299}, Pair{website='hibympufi', timestamp=317455832}, Pair{website='yljmntrclw', timestamp=411747930}]
    }

    There're duplicate 3-seq of "hibympufi-hibympufi-hibympufi" for the user "cq".
    The expected result is ["hibympufi","hibympufi","yljmntrclw"], but if you don't use a hashset to remove duplicate, it will
    be ["hibympufi","hibympufi","hibympufi"].

    */


    private class Pair {
        String website;
        int timestamp;
        int cnt;
        List<String> pattern;
        
        Pair(String website, int timestamp) {
            this.website = website;
            this.timestamp = timestamp;
        }
        
        Pair(int cnt, String... pattern) {
            this.cnt = cnt;
            this.pattern = Arrays.asList(pattern);
        }
        
        // @Override
        // public String toString() {
        //     return "Pair{" +
        //             "website='" + website + '\'' +
        //             ", timestamp=" + timestamp +
        //             ", cnt=" + cnt +
        //             ", pattern=" + pattern +
        //             '}';
        // }
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Pair>> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Pair> pairs;
            if (!dict.containsKey(username[i])) {
                pairs = new ArrayList<>();
                dict.put(username[i], pairs);
            }
            else {
                pairs = dict.get(username[i]);
            }
            
            pairs.add(new Pair(website[i], timestamp[i]));
        }
        
        // System.out.println(dict);
        
        List<String> best3Seq = Collections.emptyList();
        String best3SeqKey = "Z";
        int largestCnt = 0;
        Map<String, Pair> cntMap = new HashMap<>();
        for (List<Pair> pairs : dict.values()) {
            Collections.sort(pairs, (a, b) -> a.timestamp - b.timestamp);
            
            int len = pairs.size();
            HashSet<String> hashSet = new HashSet<>();
            for (int i = 0; i < len - 2; i++) {
                for (int j = i+1; j < len - 1; j++) {
                    for (int k = j+1; k < len; k++) {
                        String key = pairs.get(i).website + "-" + pairs.get(j).website + "-" + pairs.get(k).website;
                        if (hashSet.contains(key)) {
                            continue;
                        }
                        hashSet.add(key);
                        Pair pair;
                        if (!cntMap.containsKey(key)) {
                            pair = new Pair(0, pairs.get(i).website, pairs.get(j).website, pairs.get(k).website);
                            cntMap.put(key, pair);
                        }
                        else {
                            pair = cntMap.get(key);
                        }
                        pair.cnt++;
                        
                        if (pair.cnt > largestCnt || (pair.cnt == largestCnt && key.compareTo(best3SeqKey) < 0)) {
                            best3Seq = pair.pattern;
                            best3SeqKey = key;
                            largestCnt = pair.cnt;
                        }
                    }
                }
            }
        }
        
        return best3Seq;
    }
}