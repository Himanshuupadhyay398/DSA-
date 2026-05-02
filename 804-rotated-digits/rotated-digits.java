class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            boolean check=false;
            int temp=i;
            while(temp>0){
                int rem=temp%10;
                if(rem==3 || rem==4 || rem==7){
                    check=false;
                    break;
                    }
                if(rem==2 || rem==5 || rem==6 || rem==9){
                    check=true;  
                }
                temp=temp/10;
            }
            if(check) count++;
        }
    return count;
    }
}