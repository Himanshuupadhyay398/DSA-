class Solution {
    public int romanToInt(String s) {
        int sum=0;
        int n=s.length();
        Map<Character,Integer> map=Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        for(int i=0;i<n-1;i++){
            char ch=s.charAt(i);
            if(map.get(ch)<map.get(s.charAt(i+1))){
                sum-=map.get(ch);
            }else{
                sum+=map.get(ch);
            }
        }
    return sum+map.get(s.charAt(n-1));
    }
}