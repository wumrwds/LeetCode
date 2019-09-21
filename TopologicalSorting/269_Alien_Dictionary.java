class Solution {
    public String alienOrder(String[] words) {
        // build gragh
        Map<Character, Set<Character>> adjacencyList = buildGragh(words);

        // calculate indegrees
        Map<Character, Integer> indegrees = calculateIndegrees(adjacencyList);

        // topological sorting
        Queue<Character> tsQueue = new LinkedList<>();
        Set<Character> tsSet = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                tsQueue.offer(entry.getKey());
            }
        }

        // bfs
        StringBuilder ans = new StringBuilder("");
        while (!tsQueue.isEmpty()) {
            Character head = tsQueue.poll();
            ans.append(head);
            tsSet.add(head);

            Set<Character> neighbors = adjacencyList.get(head);
            for (Character neighbor : neighbors) {
                if (tsSet.contains(neighbor)) {
                    continue;
                }

                int indegreeAfter = indegrees.get(neighbor) - 1;
                indegrees.put(neighbor, indegreeAfter);

                if (indegreeAfter == 0) {
                    tsQueue.add(neighbor);
                }
            }
        }

        for (Integer indegree : indegrees.values()) {
            if (indegree != 0) {
                return "";
            }
        }

        return ans.toString();
    }

    private Map<Character, Set<Character>> buildGragh(String[] words) {
        Map<Character, Set<Character>> adjacencyList = new HashMap<>();

        // initialize
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                adjacencyList.putIfAbsent(words[i].charAt(j), new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            int minLen = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLen; j++) {
                char word1Char = word1.charAt(j);
                char word2Char = word2.charAt(j);

                if (word1Char != word2Char) {
                    adjacencyList.get(word1Char).add(word2Char);
                    break;
                }
            }
        }

        return adjacencyList;
    }

    private Map<Character, Integer> calculateIndegrees(Map<Character, Set<Character>> adjacencyList) {
        Map<Character, Integer> indegrees = new HashMap<>();

        for (Character node : adjacencyList.keySet()) {
            indegrees.put(node, 0);
        }

        for (Set<Character> neighbors : adjacencyList.values()) {
            for (Character neighbor : neighbors) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }

        return indegrees;
    }
}