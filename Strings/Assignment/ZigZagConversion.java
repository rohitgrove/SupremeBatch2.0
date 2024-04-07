import java.util.ArrayList;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        ArrayList<StringBuilder> zigzag = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            zigzag.add(new StringBuilder());
        }

        int i = 0, row = 0;
        boolean direction = true; // true for top to bottom, false for bottom to top

        while (i < s.length()) {
            if (direction) {
                while (row < numRows && i < s.length()) {
                    zigzag.get(row++).append(s.charAt(i++));
                }
                row -= 2;
                direction = false;
            } else {
                while (row >= 0 && i < s.length()) {
                    zigzag.get(row--).append(s.charAt(i++));
                }
                row = 1;
                direction = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : zigzag) {
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println(convert(s1, numRows1));
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println(convert(s2, numRows2));
        String s3 = "A";
        int numRows3 = 1;
        System.out.println(convert(s3, numRows3));
    }
}
