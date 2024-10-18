// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
public class RomanToInteger {
    public static String intToRoman(int num) {
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int values[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String ans = "";
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                ans += romanSymbols[i];
                num -= values[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int num1 = 3;
        System.out.println(intToRoman(num1));
        int num2 = 58;
        System.out.println(intToRoman(num2));
        int num3 = 1994;
        System.out.println(intToRoman(num3));
    }
}
