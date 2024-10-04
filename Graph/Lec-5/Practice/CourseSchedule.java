import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] row : prerequisites) {
            int u = row[0];
            int v = row[1];
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }

        return topoSort(numCourses, adjList).size() == numCourses;
    }

    public static List<Integer> topoSort(int n, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, (indegree.get(nbr) + 1));
            }
        }

        for (int node = 0; node < n; node++) {
            if (!indegree.containsKey(node)) {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            ans.add(frontNode);

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                int count = indegree.get(nbr);
                indegree.put(nbr, count - 1);

                if (indegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int numCourses1 = 2,
                prerequisites1[][] = { { 1, 0 } };
        System.out.println(canFinish(numCourses1, prerequisites1));
        int numCourses2 = 2,
                prerequisites2[][] = { { 1, 0 },
                        { 0, 1 } };
        System.out.println(canFinish(numCourses2, prerequisites2));
    }
}