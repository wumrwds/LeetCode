package top.wumrwds.util;

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    private class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        TrieNode() {
            links = new TrieNode[R];
        }

        private boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        private TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        private TrieNode create(char ch) {
            links[ch - 'a'] = new TrieNode();
            return links[ch - 'a'];
        }

        private void setEnd() {
            isEnd = true;
        }

        private boolean isEnd() {
            return isEnd;
        }
    }


    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.contains(ch)) {
                node = node.get(ch);
            }
            else {
                node = node.create(ch);
            }
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.contains(ch)) {
                node = node.get(ch);
            }
            else {
                // not found
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        boolean apple = trie.search("apple");// returns true
        boolean app1 = trie.search("app");// returns false
        boolean app2 = trie.startsWith("app");// returns true
        trie.insert("app");
        boolean app3 = trie.search("app");// returns true

        System.out.println(apple);
        System.out.println(app1);
        System.out.println(app2);
        System.out.println(app3);
    }
}
