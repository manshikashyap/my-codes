class pair implements Comparable<pair>{
    int dur;
    int end;
    pair(int d,int e){
        dur=d;
        end=e;
    }
    public int compareTo(pair p){
        if(end<p.end)return -1;
        else if(end>p.end)return 1;
        else  return 0;
           
    }
}
class Solution {
    public int scheduleCourse(int[][] courses) {
        int n=courses.length;
        pair arr[] = new pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new pair(courses[i][0],courses[i][1]);
        }
        Arrays.sort(arr,pair::compareTo);
        PriorityQueue<Integer> heap = new PriorityQueue<>((d1, d2) -> Integer.compare(d2, d1));
        int c=0;
        for(int i=0;i<n;i++){
            pair p =arr[i];
            c+=p.dur;
            heap.add(p.dur);
            if(c>p.end){
                c-=heap.poll();
            }
        }
        return heap.size();
    }
}