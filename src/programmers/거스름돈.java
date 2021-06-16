package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 거스름돈 {

    @Test
    void test() {
        Assertions.assertEquals(4, solution(5, new int[]{1,2,5}));
    }

    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        for (int m : money) {
            for (int j=m; j<=n; j++) {
                dp[j] += dp[j-m];
            }
        }

        return dp[n];
    }

}
