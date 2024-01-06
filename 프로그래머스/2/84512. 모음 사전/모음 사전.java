import java.util.*;

class Solution {
    
    static List<String> dictionary = new ArrayList<>();
    
    public void recursion(String p, int step) {
        if (step == 6) {
            return;
        }
        if (!p.equals("")) {
            dictionary.add(p);
        }
        char[] words = {'A', 'E', 'I', 'O', 'U'};
        for (char c : words) {
            recursion(p + c, step + 1);
        }
    }
    
    public int solution(String word) {
        recursion("", 0);
        int answer = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}