package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */
public class boj2156 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] wines = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wines[1];
        if (n >= 2) {
            dp[2] = wines[1] + wines[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + wines[i - 1]) + wines[i]);
        }

        System.out.println(dp[n]);
    }
}
