import java.util.ArrayList;

public class LeaserBeamsInABank {
    public static int numberOfBeams(String[] bank) {
        ArrayList<Integer> deviceCount = new ArrayList<>();
        for (String row : bank) {
            deviceCount.add(countsOfBinary(row));
        }    

        int leaser = 0;
        for (int i = 0; i < deviceCount.size(); i++) {
            int j = i + 1;
            while (j < deviceCount.size()) {
                leaser += deviceCount.get(i) * deviceCount.get(j);
                if (deviceCount.get(j) == 0) {
                    j++;
                } else {
                    break;
                }
            }
        }

        return leaser;
    }

    public static Integer countsOfBinary(String row) {
        int c = 0;
        for (int i = 0; i < row.length(); i++) {
            c += row.charAt(i) - '0';
        }

        return c;
    }

    public static void main(String[] args) {
        String bank1[] = { "011001", "000000", "010100", "001000" };
        System.out.println(numberOfBeams(bank1));
        String bank2[] = { "000", "111", "000" };
        System.out.println(numberOfBeams(bank2));
    }
}
