package solution._0537.ComplexNumberMultiplication;

public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        String[] arr1 = num1.split("\\+");
        int a = Integer.parseInt(arr1[0]);
        int b = Integer.parseInt(arr1[1].substring(0, arr1[1].length() - 1));

        String[] arr2 = num2.split("\\+");
        int c = Integer.parseInt(arr2[0]);
        int d = Integer.parseInt(arr2[1].substring(0, arr2[1].length() - 1));

        String s1 = (a * c - b * d) + "+";
        return s1 + (a*d + b*c) + "i";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().complexNumberMultiply("1+-1i", "1+-1i"));
    }


}
