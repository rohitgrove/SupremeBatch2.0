import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseShedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] i : prerequisites) {
            int u = i[0];
            int v = i[1];
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }

        return topoSort(numCourses, adjList).size() == numCourses;
    }

    public static List<Integer> topoSort(int n, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }   

        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < n; node++) {
            if (indegree.containsKey(node) == false) {
                q.add(node);
            }
        }

        List<Integer> ans = new ArrayList<>();
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