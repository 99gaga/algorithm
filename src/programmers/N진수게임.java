package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N진수게임 {

    @Test
    void test() {
        Assertions.assertEquals("0111", solution(2, 4, 2, 1));
        Assertions.assertEquals("02468ACE11111111", solution(16, 16, 2, 1));
        Assertions.assertEquals("13579BDF01234567", solution(16, 16, 2, 2));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder("0");

        int number = 0;
        while (temp.length() - 1 < t * m) {
            temp.append(convertNumber(number, n));
            number++;
        }

        String tempStr = temp.toString();
        for (int i = p - 1; i <= (t - 1) * m + p; i += m) {
            answer.append(tempStr.charAt(i));
        }

        return answer.toString();
    }

    public String convertNumber(int number, int n) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int r = number % n;
            if (r >= 10) {
                char s = (char) ('A' + r - 10);
                sb.insert(0, s);
            } else {
                sb.insert(0, r);
            }
            number /= n;
        }
        return sb.toString();
    }
}
