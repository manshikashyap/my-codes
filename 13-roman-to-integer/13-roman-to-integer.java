class Solution {
    public int romanToInt(String s) {
        int sum=0;
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            char c='a';
            if(i<=s.length()-2)c=s.charAt(i+1);
            if(ch=='M'){
                sum+=1000;
            }
            else if(ch=='C'){
                if(c=='M'){
                    sum+=900;
                    i++;
                }
                else if(c=='D'){
                    sum+=400;
                    i++;
                }
                else{
                    sum+=100;
                }
            }
            else if(ch=='D'){
                sum+=500;
            }
            else if(ch=='L'){
                sum+=50;
            }
            else if(ch=='X'){
                if(c=='L'){
                    sum+=40;
                    i++;
                }
                else if(c=='C'){
                    sum+=90;
                    i++;
                }
                else{
                    sum+=10;
                }
            }
            else if(ch=='V'){
                sum+=5;
            }
            else if(ch=='I'){
                if(c=='X'){
                    sum+=9;
                    i++;
                }
                else if(c=='V'){
                    sum+=4;
                    i++;
                }
                else{
                    sum+=1;
                }
            }
            i++;
        }
        return sum;
    }
}