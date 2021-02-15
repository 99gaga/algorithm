package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 * 3 <= N <= 5000
 */
public class boj2839 {

    static final int[] weights = {3, 5};
    static final int NO_VALUE = 5001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배달해야할 설탕 무게
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        Arrays.fill(d, NO_VALUE);

        d[0] = 0;
        for (int i = 0; i < weights.length; i++) {

            int weight = weights[i];
            for (int j = weight; j <= n; j++) {
                if (d[j - weight] != NO_VALUE) {
                    d[j] = Math.min(d[j], d[j - weight] + 1);
                }
            }
        }

        if (d[n] == NO_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(d[n]);
        }
    }
}

