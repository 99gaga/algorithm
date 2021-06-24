package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 숫자의표현 {

    @Test
    void test() {
        Assertions.assertEquals(4, solution(15));
    }

    public int solution(int n) {
        int answer = 0;

        int sum = 0;
        int left = 1, right = 0;

        while (right <= n) {
            if (sum < n) {
                sum += ++right;
            } else if (sum > n) {
                sum -= left++;
            } else {
                answer++;
                sum -= left++;
            }
        }

        return answer;
    }

}
