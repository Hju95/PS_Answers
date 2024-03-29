import java.lang.*;

class Solution {
    public long solution(int a, int b) {
        
        long answer = 0;
        int minNum = Math.min(a, b);
        int k = Math.abs(a - b);
            
        if (k == 0) {return minNum;}
        
        for (int i = 0; i<(k + 1); i++) {
            answer += (minNum + i);
        }
        
        return answer;
    }
}