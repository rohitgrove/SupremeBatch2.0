import java.util.List;

class Pair {
    public int number;
    public String word;

    public Pair(int number, String word) {
        this.number = number;
        this.word = word;
    }
}

public class IntegerToEnglishWords {
    public static List<Pair> mp = List.of(
        new Pair(1000000000, "Billion"),
        new Pair(1000000, "Million"),
        new Pair(1000, "Thousand"),
        new Pair(100, "Hundred"),
        new Pair(90, "Ninety"),
        new Pair(80, "Eighty"),
        new Pair(70, "Seventy"),
        new Pair(60, "Sixty"),
        new Pair(50, "Fifty"),
        new Pair(40, "Forty"),
        new Pair(30, "Thirty"),
        new Pair(20, "Twenty"),
        new Pair(19, "Nineteen"),
        new Pair(18, "Eighteen"),
        new Pair(17, "Seventeen"),
        new Pair(16, "Sixteen"),
        new Pair(15, "Fifteen"),
        new Pair(14, "Fourteen"),
        new Pair(13, "Thirteen"),
        new Pair(12, "Twelve"),
        new Pair(11, "Eleven"),
        new Pair(10, "Ten"),
        new Pair(9, "Nine"),
        new Pair(8, "Eight"),
        new Pair(7, "Seven"),
        new Pair(6, "Six"),
        new Pair(5, "Five"),
        new Pair(4, "Four"),
        new Pair(3, "Three"),
        new Pair(2, "Two"),
        new Pair(1, "One"));

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        for (Pair it : mp) {
            if (num >= it.number) {
                String a = "";
                if (num >= 100) {
                    a = numberToWords(num / it.number) + " ";
                }
                String b = it.word;

                String c = "";
                if (num % it.number != 0) {
                    c = " " + numberToWords(num % it.number);
                }
                
                return a + b + c;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        int num1 = 123;
        System.out.println(numberToWords(num1));
        int num2 = 12345;
        System.out.println(numberToWords(num2));
        int num3 = 1234567;
        System.out.println(numberToWords(num3));
    }
}
