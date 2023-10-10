class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int len = s.length();
        int total = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i) == '('){
                total++;
            }else if(s.charAt(i) == ')'){
                total--;
            }
            if(total < 0){
                answer = false;
                break;
            }
        }
        if(total == 0){
            answer = true;
        }else{
            answer = false;
        }

        return answer;
    }
}
