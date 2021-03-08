package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 2020 KAKAO BLIND RECRUITMENT
 * 괄호 변환
 */
public class ConvertParentheses {

    @Test
    public void test() {
        Assertions.assertEquals("(()())()", solution("(()())()"));
        Assertions.assertEquals("()", solution(")("));
        Assertions.assertEquals("()(())()", solution("()))((()"));
    }

    public String solution(String p) {
        return parenthesesConvert(p);
    }

    public String parenthesesConvert(String p) {
        if (p.length() == 0) return p;
        StringBuilder result = new StringBuilder();

        int criteria = 0;
        int[] cnt = new int[2];
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(') cnt[0]++;
            if (p.charAt(i) == ')') cnt[1]++;

            if (cnt[0] == cnt[1]) {
                criteria = i + 1;
                break;
            }
        }

        String u = p.substring(0, criteria);
        String v = p.substring(criteria);

        if (isValid(u)) {
            result.append(u).append(parenthesesConvert(v));
        } else {
            result.append("(").append(parenthesesConvert(v)).append(")").append(convertAttach(u));
        }

        return result.toString();
    }

    private String convertAttach(String u) {
        StringBuilder sb = new StringBuilder();
        u = u.substring(1, u.length() - 1);
        for (int i=0; i<u.length(); i++) {
            if (u.charAt(i) == '(') sb.append(')');
            if (u.charAt(i) == ')') sb.append('(');
        }

        return sb.toString();
    }

    private boolean isValid(String u) {
        int len = u.length();
        int open = 0;
        for (int i = 0; i < len; i++) {
            if (u.charAt(i) == '(') {
                open++;
            }
            if (u.charAt(i) == ')') {
                if (open == 0) return false;
                open--;
            }
        }

        return true;
    }
}
