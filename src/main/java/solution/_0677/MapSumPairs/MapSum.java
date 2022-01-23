package solution._0677.MapSumPairs;

import java.util.TreeMap;

public class MapSum {

    Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node p = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            p.next.putIfAbsent(c, new Node());
            p = p.next.get(c);
        }
        p.val = val;
    }

    public int sum(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!p.next.containsKey(c)){
                return 0;
            }
            p = p.next.get(c);
        }
        int sum = p.val;
        for (Node node : p.next.values()) {
            sum += sum(node);
        }
        return sum;
    }

    private int sum(Node node){
        int sum = 0;
        if (node.val != 0){
            sum += node.val;
        }
        for (Node childNode : node.next.values()) {
            sum += sum(childNode);
        }
        return sum;
    }


    static class Node{

        int val;
        TreeMap<Character, Node> next;

        public Node() {
            this(0);
        }

        public Node(int val) {
            this.val = val;
            this.next = new TreeMap<>();
        }
    }

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("apple"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)


    }

}
