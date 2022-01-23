package solution._0211.DesignAddAndSearchWordsDataStructure;

import java.util.TreeMap;

public class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            p.next.putIfAbsent(c, new Node());
            p = p.next.get(c);
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(Node node, String word, int index) {
        if (index == word.length()){
            return node.isWord;
        }

        char c = word.charAt(index);
        if ('.' == c){
            for (Node childNode : node.next.values()) {
                if (search(childNode, word, index + 1)){
                    return true;
                }
            }
            return false;
        }else {
            if (!node.next.containsKey(c)){
                return false;
            }
            return search( node.next.get(c), word,index + 1);
        }
    }

    static class Node{

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
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));// return False
        System.out.println(wordDictionary.search("bad"));// return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True

    }

}
