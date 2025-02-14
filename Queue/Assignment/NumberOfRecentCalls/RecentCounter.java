import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q = new LinkedList<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        // 1.
        q.offer(t);

        // 2. pop invalid req. older, older than t - 3000
        while (!q.isEmpty() && q.peek() < (t - 3000)) {
            q.poll();
        }

        // 3. now q has only number of recent calls : R = [t - 3000, t]
        return q.size();
    }
}