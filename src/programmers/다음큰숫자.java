package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 다음큰숫자 {

    @Test
    void test() {
        Assertions.assertEquals(83, solution(78));
        Assertions.assertEquals(23, solution(15));
    }

    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        while (true) {
            if (cnt == Integer.bitCount(++n)) break;
        }
        return n;
    }
}
