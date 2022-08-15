package solution._0003.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int customLengthOfLongestSubstringTwo(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int thisSum = 0;
        int maxSum = 0;
        Set<Character> set = new HashSet<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (!set.contains(c)) {
                // 扩张

                thisSum++;
                set.add(c);
                r++;


            }else {
                // 收缩

            }
        }

        return maxSum;
    }

    public static int customLengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0){
            return 0;
        }

        Set<Character> set = new HashSet<>();

        int maxSum = 0;
        int thisSum = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            char c = s.charAt(right);

            if (set.contains(c)){
                while (s.charAt(left) != c){
                    set.remove(s.charAt(left));
                    left++;

                    thisSum--;
                }
                left++;

                set.add(c);
            }else {
                set.add(c);

                thisSum++;

                if (thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int n = s.length();

        int rk = -1, maxValue = 0;
        for(int lk = 0; lk < n; lk++){
            if (lk != 0){
                set.remove(s.charAt(lk-1));
            }

            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            maxValue = Math.max(maxValue, rk - lk + 1 );
        }

        return maxValue;
    }

}
