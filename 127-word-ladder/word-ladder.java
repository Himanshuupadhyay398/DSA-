class Solution {
    class pair{
        String s;
        int len;
        
        pair(String s,int len){
            this.s=s;
            this.len=len;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<pair> q=new LinkedList<>();
        
        q.add(new pair(beginWord,1));
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            
            pair curr=q.poll();
            String str=curr.s;
            int length=curr.len;
            
            if(str.equals(endWord)){
                return length;
            }
            
            for(int i=0;i<str.length();i++){
                char []arr=str.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String next=new String(arr);
                    if(set.contains(next)){
                        q.add(new pair(next,length+1));
                        set.remove(next);
                    }
                }
            }
        }
    return 0;
    }
}