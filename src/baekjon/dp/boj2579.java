package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */
public class boj2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단의 개수
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] stairs = new int[n + 1];

        for (int i=1; i<=n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if (n > 1) {
            dp[2] = stairs[1] + stairs[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] += Math.max(dp[i - 2], stairs[i - 1] + dp[i - 3]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}
