class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int len  = nums.length;
        for(int i=0;i<=len-3;i++){
            for(int j=i+1;j<=len-2;j++){
                for(int k=j+1;k<=len-1;k++){
                    //System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                    answer += primeNumber(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        return answer;
    }
    
    int primeNumber(int n){
        int result = 1;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                result = 0;
                break;
            }
        }
        return result;
    }
    
}
