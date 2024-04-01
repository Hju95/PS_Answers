import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 출구 지점 기준 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int cameraPosition = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            if (route[0] > cameraPosition) {
                cameraPosition = route[1];
                count++;
            }
        }
        return count;
    }
}