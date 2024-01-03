class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speak = {"aya", "ye", "woo", "ma"};

        for (String i : babbling) {
            for (String j : speak) {
                if (i.contains(j + j)) {
                    break;
                } else {
                    i = i.replace(j, "-");
                }
            }
            i = i.replace("-", "");
            if (!i.isEmpty()) {
                continue;
            } else {
                answer++;
            }
        }
        return answer;
    }
}