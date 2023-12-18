import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String[] split = s1.split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        String s2 = br.readLine();
        int[] arr = Arrays.stream(s2.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int windowSum = 0;
        int maxSum = 0;

        // 처음 K개 요소의 합 구하기
        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum; // 최대 부분합 초기화

        // 슬라이딩 윈도우를 이용하여 부분합 계산
        for (int i = K; i < N; i++) {
            windowSum += arr[i] - arr[i - K]; // 새로운 요소 추가 및 이전 요소 제거
            maxSum = Math.max(maxSum, windowSum); // 최대 부분합 갱신
        }

        System.out.println(maxSum); // 최대 부분합 출력
    }
}
