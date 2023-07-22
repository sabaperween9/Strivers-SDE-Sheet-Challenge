// ================== Approach - 1 (getting TLE)=====================================================
class MedianFinder {
    ArrayList<Integer> al;
    public MedianFinder() {
        al = new ArrayList<>();
    }
    
    public void addNum(int num) {
        al.add(num);
        Collections.sort(al);
    }
    
    public double findMedian() {
        int n = al.size();
        if(n % 2 != 0) 
            return (double)al.get(n / 2);
        return ((double)al.get(n/2) + (double)al.get(n/2 - 1)) / 2;
    }
}

// ================= Approach - 2 Best solutions===========================================

class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size() < min.size())
           max.offer(min.poll());
    }
    public double findMedian() {
        if(max.size() == min.size()) return (min.peek() + max.peek() * 1.0) / 2;
        else return max.peek();   
    }
}