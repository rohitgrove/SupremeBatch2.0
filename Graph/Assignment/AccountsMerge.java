import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountsMerge {
    public static int find(int node, int parent[]) {
        if (node == parent[node])
            return node;

        return parent[node] = find(parent[node], parent);
    }

    public static void union(int x, int y, int parent[], int rank[]) {
        int u = find(x, parent);
        int v = find(y, parent);

        if (rank[u] > rank[v]) {
            parent[v] = u;
            rank[u]++;
        } else {
            parent[u] = v;
            rank[v]++;
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        int parent[] = new int[n];
        int rank[] = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        HashMap<String, Integer> mailMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int m = accounts.get(i).size();

            for (int j = 1; j < m; j++) {

                String mailAddress = accounts.get(i).get(j);

                if (!mailMap.containsKey(mailAddress)) {
                    mailMap.put(mailAddress, i);
                } else {
                    union(i, mailMap.get(mailAddress), parent, rank); // unioning ith index with the index where we
                }
            }
        }

        HashMap<Integer, Set<String>> distinctGroupMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parent[i] = find(i, parent); // further updating the parent in case of anyting left earlier

            int accountSize = accounts.get(i).size();
            distinctGroupMap.putIfAbsent(parent[i], new HashSet<>());
            distinctGroupMap.get(parent[i]).addAll(accounts.get(i).subList(1, accountSize)); // removing 0th element
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        for (int group : distinctGroupMap.keySet()) {
            List<String> emailList = new ArrayList<>(distinctGroupMap.get(group));
            Collections.sort(emailList);

            emailList.add(0, accounts.get(group).get(0)); // adding the name to the first element of the merged account
            mergedAccounts.add(emailList);
        }

        return mergedAccounts;
    }

    public static void main(String[] args) {
        List<List<String>> accounts1 = new ArrayList<>();
        accounts1.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts1.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts1.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts1.add(Arrays.asList("John", "johnnybravo@mail.com"));
        System.out.println(accountsMerge(accounts1));

        List<List<String>> accounts2 = new ArrayList<>();
        accounts2.add(Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"));
        accounts2.add(Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"));
        accounts2.add(Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"));
        accounts2.add(Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"));
        System.out.println(accountsMerge(accounts2));
    }
}
