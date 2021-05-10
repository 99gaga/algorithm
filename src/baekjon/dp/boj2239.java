package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동전 1
 */
public class boj2239 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] money = new int[n];
        for (int i=0; i<n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int m : money) {

            for (int i=m; i<=k; i++) {
                dp[i] += dp[i - m];
            }
        }

        System.out.println(dp[k]);
    }

}
