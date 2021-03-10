package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 올바른 괄호
 */
public class CorrectParenthesis {

    @Test
    public void test() {
        Assertions.assertTrue(solution("()()"));
        Assertions.assertTrue(solution("(())()"));
        Assertions.assertFalse(solution(")()("));
        Assertions.assertFalse(solution("(()("));
    }

    private boolean solution(String s) {
        int len = s.length();
        int open = 0;

        for (int idx=0; idx<len; idx++) {
            if (s.charAt(idx) == '(') {
                open++;
            } else {
                if (open == 0) {
                    return false;
                }
                open--;
            }
        }

        return open <= 0;
    }
}
