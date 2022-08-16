package solution._0003.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    // 右指针标定循环
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
                // 收缩
                while (s.charAt(left) != c){
                    set.remove(s.charAt(left));
                    left++;

                    thisSum--;
                }

                // 出循环后 s.charAt(l) == c, 左侧需右移
                left++;
                thisSum--;
                set.remove(c);

                // 处理右侧的扩张
                thisSum++;
                set.add(c);

            }else {
                // 扩张
                set.add(c);
                thisSum++;

                if (thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    // 左指针标定循环
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int n = s.length();

        // [ lk ... rk ]
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, maxValue = 0;
        for(int lk = 0; lk < n; lk++){

            // 判断 rk 右侧的字符 没有超出 && 没有包含，才能右移
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))){
                // 不断地移动右指针
                set.add(s.charAt(rk+1));
                rk++;
            }

            // 右侧先跑完，再删除左侧，左指针向右移动一格，移除一个字符
            set.remove(s.charAt(lk));

            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            maxValue = Math.max(maxValue, rk - lk + 1 );
        }

        return maxValue;
    }

}
