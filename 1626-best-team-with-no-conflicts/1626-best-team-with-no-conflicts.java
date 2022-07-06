class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int dp[]=new int[n];
        pair[] p=new pair[n];
        for(int i=0;i<n;i++){
            p[i]=new pair(scores[i],ages[i]);
        }
        Arrays.sort(p);
        int res=0;
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(p[j].score<=p[i].score){
                    max=Math.max(dp[j],max);
                }
            }
            dp[i]=max+p[i].score;
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
class pair implements Comparable<pair>{
    int score;
    int age;
    pair(int s,int a){
        score=s;
        age=a;
    }
    public int compareTo(pair p){
        if(this.age==p.age)return this.score-p.score;
        else{
            return this.age-p.age;
        }
    }
}