package solution._0208.ImplementTriePrefixTree;

import java.util.TreeMap;

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            p.next.putIfAbsent(c, new Node());
            p = p.next.get(c);
        }

        p.isWord = true;
    }

    public boolean search(String word) {
        Node p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.next.containsKey(c)){
                return false;
            }
            p = p.next.get(c);
        }
        return p.isWord;
    }

    public boolean startsWith(String prefix) {
        Node p = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!p.next.containsKey(c)){
                return false;
            }
            p = p.next.get(c);
        }

        return true;
    }


    static class Node {

        boolean isWord;
        TreeMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));


    }



}