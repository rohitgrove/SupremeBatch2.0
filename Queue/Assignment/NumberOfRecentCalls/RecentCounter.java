import java.util.Queue;
import java.util.LinkedList;

public class RecentCounter {
    public Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        // 1.
        q.add(t);
        
        // 2. pop invalid req. older, older than t - 3000
        while (!q.isEmpty() && q.peek() < (t - 3000)) {
            q.poll();
        }

        // 3. now q has only number of recent calls: R = [t - 3000, t]

        return q.size();
    }
}
