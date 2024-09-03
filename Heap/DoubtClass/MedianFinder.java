import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (maxheap.size() == 0 || num < maxheap.peek()) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }
        // both heap must have same number of elements.
        // if not, max heap have 1 more element than minheap
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        } else if (maxheap.size() > minheap.size() + 1){
            minheap.add(maxheap.poll());
        }
    }
    
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
        // non matching case
        // phle se hi maintained hai ke, maxheap main haga answer
        return maxheap.peek();
    }
}
