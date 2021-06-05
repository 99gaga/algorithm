package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 괄호회전하기 {

    @Test
    void test() {
        Assertions.assertEquals(3, solution("[](){}"));
        Assertions.assertEquals(2, solution("}]()[{"));
        Assertions.assertEquals(0, solution("[)(]"));
        Assertions.assertEquals(0, solution("}}}"));
    }

    Map<Character, Character> maps = new HashMap<>(){{
        put(']', '[');
        put('}', '{');
        put(')', '(');
    }};

    public int solution(String s) {
        int answer = 0;

        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<len; i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);

            if (isCorrect(sb.toString())) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && maps.containsKey(c) && stack.peek() == maps.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
