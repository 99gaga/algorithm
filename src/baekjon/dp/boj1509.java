package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 팰린드롬 분할
 */
public class boj1509 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray(); // 문자열
        int n = str.length; // 문자열 길이
        boolean[][] palindrome = new boolean[n+1][n+1];
        int[] dp = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int start = 1; start <= n; start++) {
            for (int end = start; end <= n; end++) {
                palindrome[start][end] = isPalindrome(str, start - 1, end - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }

    private static boolean isPalindrome(char[] str, int start, int end) {
        while (start < end) {
            if (str[start++] != str[end--]) {
                return false;
            }
        }
        return true;
    }

}
