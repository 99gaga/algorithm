package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 0 1 타일
 * https://www.acmicpc.net/problem/1904
 */
public class boj1904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // N이 주어졌을 때 만들수 있는 모든 가짓수를 구하라..

        int result = getCount(n);
        System.out.println(result);

    }

    private static int getCount(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int x = 1;
        int y = 2;
        int sum = 0;

        for (int i=3; i<=n; i++) {
            sum = (x + y) % 15746;
            x = y;
            y = sum;
        }

        return sum;
    }
}
