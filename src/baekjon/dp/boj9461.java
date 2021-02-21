package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 파도반 수열
 * https://www.acmicpc.net/problem/9461
 * 1 <= N <= 100
 */
public class boj9461 {

    public static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new long[101];
        reset();

        int t = Integer.parseInt(br.readLine());
        int n;
        for (int test = 0; test < t; test++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void reset() {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
    }

}
