class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int max[]=new int[n];
        max[0]=nums[0];
        for(int i=1;i<n;i++){
            max[i]=Math.max(nums[i],max[i-1]);
        }
        
        int prefixGcd[]=new int[n];
        for(int i=0;i<n;i++){
            prefixGcd[i]=gcd(nums[i],max[i]);
        }
        Arrays.sort(prefixGcd);
        int j=n-1;
        long sum=0;
        for(int i=0;i<n/2;i++){
            sum+=gcd(prefixGcd[i],prefixGcd[j]);
            j--;
        }
    return sum;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}