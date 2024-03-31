import java.util.*;

class Solution {
    public static int[] findClose(String s) {
        HashMap<Character, Integer> last = new HashMap<>();
        int[] result = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last.containsKey(c)) {
                result[i] = i - last.get(c);
            } else {
                result[i] = -1;
            }
            last.put(c, i);
        }
        return result;
    }
    
    public int[] solution(String s) {
        int[] result = findClose(s);
        return result;
    }
}