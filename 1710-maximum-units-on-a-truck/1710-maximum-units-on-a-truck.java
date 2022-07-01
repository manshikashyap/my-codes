
class Solution {
    public int maximumUnits(int[][] box, int trucksize) {
        Arrays.sort(box,new Comparator<int[]>(){
            @Override
            public int compare(final int[] entry1,final int[] entry2){
                if(entry1[1]>entry2[1])return -1;
                else if(entry1[1]<entry2[1])return 1;
                else return 0;
            }
        });
        int ans=0;
        for(int i=0;i<box.length;i++){
            if(trucksize>=box[i][0]){
                ans+=(box[i][1]*box[i][0]);
                trucksize-=box[i][0];
            }
            else{
                ans+=(trucksize*box[i][1]);
                break;
            }
        }
        return ans;
    }
}