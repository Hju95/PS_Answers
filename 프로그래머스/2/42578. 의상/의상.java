import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesHash = new HashMap<>();
        
        for(String[] clothe : clothes) {
            if(clothesHash.containsKey(clothe[1])) {
                int tmp = clothesHash.get(clothe[1]);
                clothesHash.put(clothe[1], tmp + 1);
            } else {
                clothesHash.put(clothe[1], 2);
            }
        }
        
        for(String k : clothesHash.keySet()) {
            answer *= clothesHash.get(k);
        }
        
        answer -= 1;
        
        return answer;
    }
}