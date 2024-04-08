public class MinimumTimeToCollectGarbage {
    public static int garbageCollection(String[] garbage, int[] travel) {
        int pickP = 0;
        int pickG = 0;
        int pickM = 0;

        int travelP = 0;
        int travelG = 0;
        int travelM = 0;

        int lastP = 0;
        int lastG = 0;
        int lastM = 0;

        for (int i = 0; i < garbage.length; i++) {
            String curr = garbage[i];
            for (int j = 0; j < curr.length(); j++) {
                char currChar = curr.charAt(j);
                if (currChar == 'P') {
                    pickP++;
                    lastP = i;
                } else if (currChar == 'G') {
                    pickG++;
                    lastG = i;
                } else if (currChar == 'M') {
                    pickM++;
                    lastM = i;
                }
            }
        }

        for (int i = 0; i < lastP; i++) {
            travelP += travel[i];
        }

        for (int i = 0; i < lastG; i++) {
            travelG += travel[i];
        }

        for (int i = 0; i < lastM; i++) {
            travelM += travel[i];
        }

        int ans = (pickP + travelP) + (pickG + travelG) + (pickM + travelM);
        return ans;
    }

    public static void main(String[] args) {
        String garbage1[] = { "G", "P", "GP", "GG" };
        int travel1[] = { 2, 4, 3 };
        System.out.println(garbageCollection(garbage1, travel1));
        String garbage2[] = { "MMM", "PGM", "GP" };
        int travel2[] = { 3, 10 };
        System.out.println(garbageCollection(garbage2, travel2));
    }
}