package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * 줄 서는 방법
 * https://school.programmers.co.kr/learn/courses/30/lessons/12936
 */
public class 줄서는방법 {

    @Test
    public void test() {
        Assertions.assertArrayEquals(
                new int[]{3, 1, 2},
                solution(3, 5)
        );
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> numbers = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            numbers.add(i);
        }

        int idx  = 0;
        k--;
        while (n > 0) {
            factorial /= n;
            answer[idx] = numbers.remove((int) (k / factorial));
            idx++;
            k %= factorial;
            n -= 1;
        }

        return answer;
    }

}
