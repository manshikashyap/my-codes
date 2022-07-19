class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        ans.add(list);
        for(int i=1;i<n;i++){
            List<Integer> temp=ans.get(i-1);
            list=new ArrayList<>();
            list.add(1);
            for(int j=1;j<temp.size();j++){
               int val=temp.get(j)+temp.get(j-1);
                list.add(val);
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}