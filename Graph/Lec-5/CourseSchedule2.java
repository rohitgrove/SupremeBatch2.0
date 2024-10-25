import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] i : prerequisites) {
            int u = i[0];
            int v = i[1];
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        // valid
        List<Integer> ans = new ArrayList<>(topSortBFS(numCourses, adjList));
        if (ans.size() == numCourses) {
            int[] ansArray = new int[ans.size()];
            for (int i = 0; i < ansArray.length; i++) {
                ansArray[i] = ans.get(i);
            }
            return ansArray;
        } else {
            // invalid
            return new int[] {};
        }
    }

    public static List<Integer> topSortBFS(int n, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // Initialize indegree of all nodes
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            for (int nbr : entry.getValue()) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }
        // push all zero indegree will node into queue
        for (int node = 0; node < n; node++) {
            if (indegree.containsKey(node) == false) {
                q.add(node);
            }
        }

        // BFS chalate hai
        while (!q.isEmpty()) {
            int frontNode = q.poll();
            ans.add(frontNode);

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                int count = indegree.get(nbr);
                indegree.put(nbr, count - 1);

                // check zero
                if (indegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numCourses1 = 2, prerequisites1[][] = { { 1, 0 } };
        printArr(findOrder(numCourses1, prerequisites1));

        int numCourses2 = 4,
                prerequisites2[][] = { { 1, 0 },
                        { 2, 0 },
                        { 3, 1 },
                        { 3, 2 } };
        printArr(findOrder(numCourses2, prerequisites2));
    }
}