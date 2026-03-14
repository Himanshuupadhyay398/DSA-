class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String> lst=new ArrayList<>();
        recurse(n,lst,"");
        if(k>lst.size()) return "";
        return lst.get(k-1);
    }
    public void recurse(int n,ArrayList<String> lst,String s){
        if(s.length()==n){
            lst.add(s);
            return;
        }

        if(s.length()==0 || s.charAt(s.length()-1)!='a'){
            recurse(n,lst,s+"a");
        }
        if(s.length()==0 || s.charAt(s.length()-1)!='b'){
            recurse(n,lst,s+"b");
        }
        if(s.length()==0 || s.charAt(s.length()-1)!='c'){
            recurse(n,lst,s+"c");
        }
    }
}