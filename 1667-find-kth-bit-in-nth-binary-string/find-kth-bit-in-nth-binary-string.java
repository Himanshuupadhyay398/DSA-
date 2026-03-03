class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder str=new StringBuilder();
        str.append('0');
        for(int i=1;i<n;i++){
            StringBuilder invt=invert(new StringBuilder(str));
            str.append('1');
            str.append(invt.reverse());
        }

        return str.charAt(k-1);
    }
    public StringBuilder invert(StringBuilder str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                str.setCharAt(i, '0');
            } else {
                str.setCharAt(i, '1');
            }
        }
    return str;
    }
}