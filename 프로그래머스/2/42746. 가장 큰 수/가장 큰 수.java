import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] list = new String[numbers.length];
        
        for (int i =0; i < numbers.length; i++) {
            list[i] = String.valueOf(numbers[i]);
        }
        
        //내림차순
        Arrays.sort(list, (a, b) -> (b + a).compareTo(a + b));
        
        if (list[0].equals("0"))
            return "0";
        
        for (String s : list) {
            answer += s;
        }
        return answer;
    }
}