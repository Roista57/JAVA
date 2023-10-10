import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        ArrayList<String[]> people = new ArrayList<String[]>();
        HashSet<String> list = new HashSet<String>();
        int[] ans = new int[2];
        int i = 0;
        for(;i<words.length;i++){
            if(i != 0){
                if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                    System.out.println("["+(i%n+1)+", "+(i/n+1)+"]");
                    ans[0] = i%n+1; ans[1] = i/n+1;
                    break;
                }
            }
            int first = list.size();
            list.add(words[i]);
            int end = list.size();
            if(first == end){
                System.out.println("["+(i%n+1)+", "+(i/n+1)+"]");
                ans[0] = i%n+1; ans[1] = i/n+1;
                break;
            }
        }
        if(i == words.length && i%n == 0){
            System.out.println("[0, 0]");
            ans[0] = 0; ans[1] = 0;
        }else if(i == words.length && i%n != 0){
            System.out.println(i); 
            ans[0] = i%n+1; ans[1] = i/n+1;
        }
        answer = ans;
        
        return answer;
    }
}
