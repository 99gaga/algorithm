package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://school.programmers.co.kr/learn/courses/30/lessons/12914
public class 멀리뛰기 {

    @Test
    void test() {
        Assertions.assertEquals(5, solution(4));
        Assertions.assertEquals(3, solution(3));
    }


    public long solution(int n) {
        if (n == 1) return 1;

        // 점화식 dp[n] = dp[n - 2] + dp[n - 1]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i < n + 1; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }

        return dp[n];
    }
}
