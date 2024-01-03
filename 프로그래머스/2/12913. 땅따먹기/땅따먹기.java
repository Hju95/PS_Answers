class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int row = land.length;

        for (int i = 1; i < row; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        answer = Math.max(land[row - 1][0], Math.max(land[row - 1][1], Math.max(land[row - 1][2], land[row - 1][3])));

        return answer;
    }
}