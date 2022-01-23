package solution._0752.OpenTheLock;

import java.util.*;

public class Solution {



    public int openLock(String[] deadends, String target) {

        HashSet<String> deadSet = new HashSet<>();
        HashMap<String, Integer> visited = new HashMap<>();

        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        if (deadSet.contains("0000")){
            return -1;
        }
        if ("0000".equals(target)){
            return 0;
        }

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.put("0000",0);

        while (!queue.isEmpty()){
            String curs = queue.remove();
            char[] chars = curs.toCharArray();

            List<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char o = chars[i];
                chars[i] = Character.forDigit ((chars[i] - '0' + 1) % 10,10);
                nexts.add(new String(chars));

                chars[i] = o;

                chars[i] = Character.forDigit((chars[i] - '0' + 9) % 10,10);
                nexts.add(new String(chars));
                chars[i] = o;
            }

            for (String next : nexts) {
                if (!deadSet.contains(next) && !visited.containsKey(next)){
                    queue.add(next);
                    visited.put(next, 1 + visited.get(curs));

                    if (next.equals(target)){
                        return visited.get(next);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println(new Solution().openLock(deadends, target));
    }


}
