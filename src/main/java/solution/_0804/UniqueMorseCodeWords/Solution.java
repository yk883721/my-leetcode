package solution._0804.UniqueMorseCodeWords;

public class Solution {

    public static void main(String[] args) {

        String[] Words = new String[]{};
        System.out.println(new Solution().uniqueMorseRepresentations(Words));

    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                String thisCode = morse[c - 'a'];
                builder.append(thisCode);
            }
            add(builder.toString());
        }
        return size;
    }

    private Node root;
    private int size = 0;

    private void add(String value){
        root = add(value, root);
    }

    private Node add(String value, Node node){
        if (node == null){
            size++;
            node = new Node(value);
        }
        if (value.compareTo(node.value) < 0){
            node.left = add(value, node.left);
        }else if (value.compareTo(node.value) > 0){
            node.right = add(value, node.right);
        }

        return node;
    }

    static class Node{

        private String value;

        private Node left;

        private Node right;

        public Node(){}

        public Node(String value){
            this.value = value;
        }

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

}
