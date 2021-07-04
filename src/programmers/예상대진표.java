package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 예상대진표 {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(8, 4, 7));
    }

    public int solution(int n, int a, int b) {
        int answer = 1;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b - a != 1 || b % 2 != 0) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }

}
