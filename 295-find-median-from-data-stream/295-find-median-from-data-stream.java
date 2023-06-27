class MedianFinder {
    PriorityQueue<Integer> left_maxHeap;
    PriorityQueue<Integer> right_minHeap;
    int size = 0;

    public MedianFinder() {
        left_maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        right_minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left_maxHeap.isEmpty() || num < left_maxHeap.peek()) {
            left_maxHeap.offer(num);
        } else {
            right_minHeap.offer(num);
        }

        if (left_maxHeap.size() - right_minHeap.size() > 1) {
            right_minHeap.offer(left_maxHeap.poll());
        } else if (right_minHeap.size() > left_maxHeap.size()) {
            left_maxHeap.offer(right_minHeap.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if (size % 2 != 0) {
            return (double)left_maxHeap.peek();
        } else {
            double num1 = left_maxHeap.peek();
            double num2 = right_minHeap.isEmpty() ? 0 : right_minHeap.peek();
            return (num1 + num2) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */