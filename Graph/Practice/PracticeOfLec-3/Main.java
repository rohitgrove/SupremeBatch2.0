public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdges(0, 1, true);
        g.addEdges(1, 2, true);
        g.addEdges(2, 3, true);
        g.addEdges(2, 4, true);
        g.addEdges(3, 5, true);
        g.addEdges(4, 5, true);
        g.addEdges(5, 6, true);
        g.addEdges(6, 7, true);

        // g.printList();
        // g.topSortDFS(8);
        int n = 8;
        System.out.println(g.topSortBFS(n));
        System.out.println(g.checkCycleDirectedGraghBFS(n));

        Graph g1 = new Graph();
        g1.addEdges(0, 1, true);
        g1.addEdges(1, 2, true);
        g1.addEdges(2, 3, true);
        g1.addEdges(3, 4, true);
        g1.addEdges(4, 5, true);
        g1.addEdges(5, 2, true);

        int n1 = 6;
        System.out.println(g1.topSortBFS(n1));
        System.out.println(g1.checkCycleDirectedGraghBFS(n1));

        Graph g2 = new Graph();
        g2.addEdges(0, 5, false);
        g2.addEdges(5, 4, false);
        g2.addEdges(4, 3, false);
        g2.addEdges(0, 6, false);
        g2.addEdges(6, 3, false);
        g2.addEdges(0, 1, false);
        g2.addEdges(1, 2, false);
        g2.addEdges(2, 3, false);

        int src = 0;
        int dest = 3;
        System.out.println(g2.shortestPathBFS(src, dest));
    }
}
