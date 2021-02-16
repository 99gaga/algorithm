package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 신나는 함수 실행
 */
public class boj9184 {

    public static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
                    .append(w(a,b,c)).append("\n");
        }

        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (isValid(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    private static boolean isValid(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}