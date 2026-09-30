import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> left;   // Max-heap
    PriorityQueue<Integer> right;  // Min-heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add to left heap first
        left.offer(num);

        // Largest element of left goes to right
        right.offer(left.poll());

        // Keep left equal to or one larger than right
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */