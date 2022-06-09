class MedianFinder {
    PriorityQueue<Integer> minheap= new PriorityQueue<>();
    PriorityQueue<Integer> maxheap= new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int lsize=maxheap.size();
        int rsize=minheap.size();
        if(lsize==0){
            maxheap.add(num);
        }
        else if(lsize==rsize){
            if(num<minheap.peek()){
                maxheap.add(num);
            }
            else{
                int temp=minheap.poll();
                minheap.add(num);
                maxheap.add(temp);
            }
        }
        else{
            if(rsize==0){
                if(num>maxheap.peek()){
                    minheap.add(num);
                }
                else{
                    int temp=maxheap.poll();
                    maxheap.add(num);
                    minheap.add(temp);
                }
            }
            else if(num>=minheap.peek()){
                minheap.add(num);
            }
            else{
                if(num<maxheap.peek()){
                    int temp=maxheap.poll();
                    maxheap.add(num);
                    minheap.add(temp);
                }
                else{
                    minheap.add(num);
                }
            }
        }
    }
    
    public double findMedian() {
        int lsize=maxheap.size();
        int rsize=minheap.size();
        if(lsize>rsize)return (double)maxheap.peek();
        else
            return (double)(minheap.peek()+maxheap.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */