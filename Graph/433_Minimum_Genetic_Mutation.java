class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int n = bank.length;
        
        // check whether vertet end is in the bank
        int endIdx = -1;
        for (int i = 1; i <= n; i++) {
            if (end.equals(bank[i-1])) {
                endIdx = i;
                break;
            }
        }
        if (endIdx < 0) {
            return -1;
        }
        
        // construct graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        
        for (int i = 1; i <= n; i++) {
            if (isConnected(start, bank[i-1])) {
                graph.get(0).add(i);
                graph.get(i).add(0);
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isConnected(bank[i-1], bank[j-1])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        // do BFS to find the minimum distance
        int dist = 0;
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        bfsQueue.add(0);
        isVisited[0] = true;
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            
            while (levelSize-- > 0) {
                Integer head = bfsQueue.poll();
                if (head == endIdx) {
                    return dist;
                }
                
                for (Integer neighbor : graph.get(head)) {
                    if (!isVisited[neighbor]) {
                        bfsQueue.offer(neighbor);
                        isVisited[neighbor] = true;
                    }
                }
            }
            
            dist++;
        }
        
        return -1;
    }
    
    private boolean isConnected(String dna1, String dna2) {
        if (dna1.length() != dna2.length()) {
            return false;
        }
        
        int cnt = 0;
        for (int i = 0; i < dna1.length(); i++) {
            if (dna1.charAt(i) != dna2.charAt(i)) {
                if (++cnt > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}








public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        
        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);
        
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) return level;
                
                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}