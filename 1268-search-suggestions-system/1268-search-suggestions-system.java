class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,TreeSet<String>> map= new HashMap<>();
        
        for(String product:products){
            String tmp="";
            for(int i=0;i<product.length();i++){
                tmp+=product.charAt(i);
                TreeSet<String> set = map.getOrDefault(tmp,new TreeSet<String>());
                set.add(product);
                map.put(tmp,set);
            }
        }
        String tmp="";
        for(int i=0;i<searchWord.length();i++){
            tmp+=searchWord.charAt(i);
            TreeSet<String> set =map.getOrDefault(tmp,new TreeSet<String>());
            List<String> temp=new ArrayList<>();
            for(int j=0;j<3 && set.size()>0;j++){
                temp.add(set.first());
                set.remove(set.first());
            }
            res.add(temp);
        }
        return res;
    }
}