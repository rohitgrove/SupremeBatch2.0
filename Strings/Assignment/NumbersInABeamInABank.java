import java.util.ArrayList;

public class NumbersInABeamInABank {
    public static Integer countDevices(String binary) {
        int c = 0;
        for (int i = 0; i < binary.length(); i++) {
            c += binary.charAt(i) - '0';
        }

        return c;
    }
    
    public static int numberOfBeams(String[] bank) {
        ArrayList<Integer> devices = new ArrayList<>();
        for (String row : bank) {
            devices.add(countDevices(row));
        }

        int beams = 0;
        for (int i = 0; i < devices.size(); i++) {
            int j = i + 1;
            while (j < devices.size()) {
                beams += devices.get(i) * devices.get(j);
                if (devices.get(j) == 0) {
                    j++;
                } else {
                    break;
                }
            }
        }

        return beams;
    }

    public static void main(String[] args) {
        String bank1[] = { "011001", "000000", "010100", "001000" };
        System.out.println(numberOfBeams(bank1));
        String bank2[] = { "000", "111", "000" };
        System.out.println(numberOfBeams(bank2));
    }
}
