public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(2, 4, false);
        g.addEdge(3, 4, false);
        g.addEdge(2, 5, false);

        int src = 5;
        boolean isCylic = g.checkCycleUndirectedGraghDFS(src);
        if (isCylic) {
            System.out.println("Cycle Present");
        } else {
            System.out.println("Cycle Not Present");
        }
    }
}