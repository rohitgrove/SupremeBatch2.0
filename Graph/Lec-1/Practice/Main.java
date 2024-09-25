public class Main {
    public static void main(String[] args) {
        // Gragh g = new Gragh();
        // g.addEdge(0, 1, false);
        // g.addEdge(1, 2, false);
        // g.addEdge(1, 3, false);
        // g.addEdge(2, 3, false);

        GragpWithWeight<Integer> g = new GragpWithWeight<>();
        g.addEdge(0, 1, 5, false);
        g.addEdge(1, 2, 10, false);
        g.addEdge(1, 3, 20, false);
        g.addEdge(2, 3, 50, false);
    }
}
