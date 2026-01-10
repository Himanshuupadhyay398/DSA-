class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int mention[]=new int[numberOfUsers];
        int offline[]=new int[numberOfUsers];

        Collections.sort(events,(a,b)->{
            int t1=Integer.parseInt(a.get(1));
            int t2=Integer.parseInt(b.get(1));
            if(t1==t2){
                if(a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")){
                    return -1;
                }else if(a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")){
                    return 1;
                }else{
                    return 0;
                }
                
            }
            return Integer.compare(t1,t2);
        });

        for(List<String> x:events){
            if(x.get(0).equals("OFFLINE")){
                int time=Integer.parseInt(x.get(1));
                int status=Integer.parseInt(x.get(2));
                offline[status]=time+60;
            }else{
                int time=Integer.parseInt(x.get(1));
                if(x.get(2).equals("ALL")){
                   for (int user = 0; user < numberOfUsers; user++) {
                        mention[user]++;
                    }
                }else if(x.get(2).equals("HERE")){
                    for (int user = 0; user < numberOfUsers; user++) {
                        if(time>=offline[user]){
                            mention[user]++;
                        }
                    }
                }else{
                    String[] str=x.get(2).split(" ");
                    for(int user=0;user<str.length;user++){
                        int st=Integer.parseInt(str[user].substring(2));
                        mention[st]++;
                    }
                }
            }
        }
    return mention;
    }
}