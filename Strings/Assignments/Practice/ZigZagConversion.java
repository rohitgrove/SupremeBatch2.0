import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static String convert1(String s, int numRows) {
        List<List<Character>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }
        StringBuilder res = new StringBuilder();

        int rowIdx = 0;
        boolean up = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ans.get(rowIdx).add(ch);
            if (rowIdx == numRows - 1) {
                up = false;
            }

            if (rowIdx == 0) {
                up = true;
            }

            if (rowIdx != numRows - 1 && up) {
                rowIdx++;
            }

            if (rowIdx >= 0 && !up) {
                rowIdx--;
            }
        }

        for (List<Character> list : ans) {
            for (Character ch : list) {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static String convert2(String s, int numRows) {
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
                    zigzag[row].append(s.charAt(i));
                    i++;
                    row++;
                }
                row -= 2;
            } else {
                while (row >= 0 && i < s.length()) {
                    zigzag[row].append(s.charAt(i));
                    row--;
                    i++;
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
        System.out.println(convert1("PAYPALISHIRING", 3));
        System.out.println(convert1("PAYPALISHIRING", 4));

    }
}
