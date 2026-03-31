class Solution {
    public String generateString(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int N=n+m-1;

        char word[]=new char[N];
        boolean remain[]=new boolean[N];

        for(int i=0;i<N;i++){
            word[i]='#';
        }

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='T'){
                int index=i;
                for(int j=0;j<m;j++){
                    if(word[index]!='#' && word[index]!=str2.charAt(j)){
                        return "";
                    }
                    word[index]=str2.charAt(j);
                    index++;
                }
            }  
        }

        for(int i=0;i<N;i++){
            if(word[i]=='#'){
                word[i]='a';
                remain[i]=true;
            }
        }

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='F'){
                if(isSame(word,str2,i,m)){
                    boolean change=false;
                    for(int k=i+m-1;k>=i;k--){
                        if(remain[k]){
                            word[k]='b';
                            remain[k]=false;
                            change=true;
                            break;
                        }
                    }

                    if(!change) return "";
                }
            }
        }
    return new String(word);
    }
     private boolean isSame(char[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i] != str2.charAt(j)) return false;
            i++;
        }
        return true;
    }
}