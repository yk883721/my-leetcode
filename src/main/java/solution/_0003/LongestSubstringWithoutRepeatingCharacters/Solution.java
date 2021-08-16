package solution._0003.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
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
