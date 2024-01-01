import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        for(String numbers : intStrs) {
            int i = Integer.parseInt(numbers.substring(s, s + l));
            if (i > k) {
                answer.add(i);
            }
        }
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}