package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 * 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오.
 * 0으로 시작하는 수는 없다
 * 1 <= N <= 100
 */
public class boj10844 {

    static final long REMAINDER = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % REMAINDER;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % REMAINDER;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % REMAINDER;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % REMAINDER);
    }
}