import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseShedule1 {
    public static void topologicalSortBFS(int n, List<Integer> topoSort, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!indegree.containsKey(i)) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            topoSort.add(frontNode);

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

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i[] : prerequisites) {
            int u = i[0];
            int v = i[1];
            adjList.put(v, new ArrayList<>());
            adjList.get(v).add(u);
        }

        List<Integer> topoSort = new ArrayList<>();
        topologicalSortBFS(numCourses, topoSort, adjList);
        return topoSort.size() == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2, prerequisites1[][] = { { 1, 0 } };
        System.out.println(canFinish(numCourses, prerequisites1));
        int prerequisites2[][] = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(numCourses, prerequisites2));
    }
}