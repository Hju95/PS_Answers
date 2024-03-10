import java.util.*;

class Solution
{
    public int solution(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}