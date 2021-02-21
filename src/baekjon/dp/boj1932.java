package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 */
public class boj1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 삼각형의 크기
        int n = Integer.parseInt(br.readLine());

        // 삼각형 숫자 입력
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];

            String[] input = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(getMaxValue(triangle, n));
    }

    private static int getMaxValue(int[][] triangle, int n) {

        for (int i = n-2; i >= 0; i--) {
            for (int j=0; j<triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        return triangle[0][0];
    }
}
