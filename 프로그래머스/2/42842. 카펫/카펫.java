class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 격자의 수
        
        for (int i = 1; i <= (int)Math.sqrt(total); i++) { // Math.sqrt의 결과를 int로 형 변환
            if (total % i == 0) { // i가 total의 약수인 경우
                int j = total / i; // 다른 약수
                if ((i - 2) * (j - 2) == yellow) { // 내부 노란색 격자의 수 조건 확인
                    return new int[] {Math.max(i, j), Math.min(i, j)}; // 가로, 세로 순으로 배열에 담아 반환
                }
            }
        }
        return new int[] {0, 0}; // 조건을 만족하는 경우가 없으면 0,0 반환
    }
}