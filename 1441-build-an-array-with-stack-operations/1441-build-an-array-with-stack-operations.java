class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int j=0;
        for(int i=1;i<=target[target.length-1];i++){
            ans.add("Push");
            if(target[j]!=i)ans.add("Pop");
            else j++;
        }
        return ans;
    }
}