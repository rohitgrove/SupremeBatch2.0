public class Main {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        String[] methods = { "StockSpanner", "next", "next", "next", "next", "next", "next", "next" };
        int[][] params = { {}, { 100 }, { 80 }, { 60 }, { 70 }, { 60 }, { 75 }, { 85 } };

        for (int i = 1; i < methods.length; i++) {
            if (methods[i].equals("next")) {
                int result = obj.next(params[i][0]);
                System.out.println(result);
            }
        }
    }
}
