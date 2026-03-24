import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {
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

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] row : prerequisites) {
            int u = row[0];
            int v = row[1];
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        List<Integer> topoOrder = new ArrayList<>();

        topoSortUsingBFS(numCourses, topoOrder, adjList);

        return topoOrder.size() == numCourses;
    }

    public static void main(String[] args) {
        int numCourses1 = 2, prerequisites1[][] = { { 1, 0 } };
        System.out.println(canFinish(numCourses1, prerequisites1));
        int numCourses2 = 2,
                prerequisites2[][] = { { 1, 0 },
                        { 0, 1 } };
        System.out.println(canFinish(numCourses2, prerequisites2));
    }
}
