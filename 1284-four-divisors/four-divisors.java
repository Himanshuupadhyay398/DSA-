class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int x:nums){
            int count=0,sum=0;
            for(int i=1;i*i<=x;i++){
                if(x%i==0){
                    int val1=i,val2=x/i;
                    if(val1==val2){
                        count++;
                        sum+=i;
                    } 
                    else{
                        count+=2;
                        sum+=val1 + val2;
                    }
                }
                if(count>4) break;
            }
            if(count==4){
                total+=sum;
            }
        }
    return total;
    }
}