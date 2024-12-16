public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder zigzag[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            zigzag[i] = new StringBuilder();
        }

        int i = 0, row = 0;
        boolean direction = true;

        while (i < s.length()) {
            if (direction) {
                while (row < numRows && i < s.length()) {
                    zigzag[row++].append(s.charAt(i++));
                }
                row -= 2;
            } else {
                while (row >= 0 && i < s.length()) {
                    zigzag[row--].append(s.charAt(i++));
                }
                row = 1;
            }
            direction = !direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder str : zigzag) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println(convert(s1, numRows1));
        numRows1 = 4;
        System.out.println(convert(s1, numRows1));
    }
}
