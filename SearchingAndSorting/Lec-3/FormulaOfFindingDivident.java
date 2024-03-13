public class FormulaOfFindingDivident {
    public static void main(String[] args) {
        int divisor = 7;
        int divident = 29;
        int questient = divident / divisor;
        int remainder = divident % divisor;
        int ans = (questient * divisor) + remainder;
        System.out.println(ans);
    }
}