package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class n제곱배열자르기 {

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(3, 2, 5), new int[]{3,2,2,3});
        Assertions.assertArrayEquals(solution(4, 7, 14), new int[]{4,3,3,3,4,4,4,4});
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            int value = (int) Math.max(i / n, i % n) + 1;
            answer[idx++] = value;
        }
        return answer;
    }
}
