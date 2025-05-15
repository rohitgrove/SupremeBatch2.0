import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseShedule2 {
    public static void topoOrderTravarsal(int n, List<Integer> topoOrder, HashMap<Integer, List<Integer>> adj) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int src : adj.keySet()) {
            for (int nbr : adj.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int src = 0; src < n; src++) {
            if (!indegree.containsKey(src)) {
                q.offer(src);
            }
        }

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            topoOrder.add(frontNode);

            if (!adj.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adj.get(frontNode)) {
                indegree.put(nbr, indegree.get(nbr) - 1);

                if (indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }
    }

    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] row : prerequisites) {
            int u = row[0];
            int v = row[1];
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(u);
        }

        List<Integer> topoOrder = new ArrayList<>();

        topoOrderTravarsal(numCourses, topoOrder, adj);

        if (topoOrder.size() == numCourses) {
            int topo[] = new int[topoOrder.size()];
            for (int i = 0; i < topo.length; i++) {
                topo[i] = topoOrder.get(i);
            }
            return topo;
        } else {
            return new int[] {};
        }
    }

    public static void printArr(int[] canFinish) {
        for (int i = 0; i < canFinish.length; i++) {
            System.out.print(canFinish[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numCourses = 2, prerequisites1[][] = { { 1, 0 } };
        printArr(canFinish(numCourses, prerequisites1));
        int prerequisites2[][] = { { 1, 0 }, { 0, 1 } };
        printArr(canFinish(numCourses, prerequisites2));
    }
}