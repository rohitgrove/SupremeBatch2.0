public class NumberOfLaserBeams {
    public static int numberOfBeams(String bank[]) {
        int devices[] = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            devices[i] = countDevices(bank[i]);
        }

        int beams = 0;
        for (int i = 0; i < devices.length; i++) {
            int j = i + 1;
            while (j < devices.length) {
                beams += devices[i] * devices[j];
                if (devices[j] == 0) {
                    j++;
                } else {
                    break;
                }
            }
        }

        return beams;
    }

    public static int countDevices(String row) {
        int c = 0;
        for (int i = 0; i < row.length(); i++) {
            char b = row.charAt(i);
            c += b - '0';
        }

        return c;
    }

    public static void main(String[] args) {
        String bank1[] = {"011001", "000000", "010100", "001000"};
        System.out.println(numberOfBeams(bank1));
        String bank2[] = {"000", "111", "000"};
        System.out.println(numberOfBeams(bank2));
    }
}
