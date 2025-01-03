public class IntegerToEnglishWordsSecondApproach {
    public static int numbers[] = { 1000000000, 1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12,
            11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    public static String words[] = { "Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty",
            "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen",
            "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two",
            "One" };

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        for (int i = 0; i < numbers.length; i++) {
            if (num >= numbers[i]) {
                String a = "";
                if (num >= 100) {
                    a = numberToWords(num / numbers[i]) + " ";
                }
                String b = words[i];

                String c = "";
                if (num % numbers[i] != 0) {
                    c = " " + numberToWords(num % numbers[i]);
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
