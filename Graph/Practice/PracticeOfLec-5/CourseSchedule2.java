import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public static void topoSortUsingBFS(int numCourses, List<Integer> topoOrder, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < numCourses; node++) {
            if (!indegree.containsKey(node)) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            topoOrder.add(frontNode);

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                indegree.put(nbr, indegree.get(nbr) - 1);

                if (indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] row : prerequisites) {
            int u = row[0];
            int v = row[1];
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        List<Integer> topoOrder = new ArrayList<>();

        topoSortUsingBFS(numCourses, topoOrder, adjList);

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

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numCourses1 = 2, prerequisites1[][] = { { 1, 0 } };
        printArr(findOrder(numCourses1, prerequisites1));
        int numCourses = 4;
        int prerequisites[][] = { { 1, 0 },
                { 2, 0 },
                { 3, 1 },
                { 3, 2 } };
        printArr(findOrder(numCourses, prerequisites));
    }
}
