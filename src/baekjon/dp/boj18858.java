package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj18858 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNM = br.readLine().split(" ");
        int n = Integer.parseInt(inputNM[0]);
        int m = Integer.parseInt(inputNM[1]);

        /**
         * 길이가 3인 수열 a1, a2, a3가 산임은 a1 < a2 > a3를 의미한다
         * 수열이 논산임은 인접한 세항이 산인 경우가 없음
         *
         */


    }
    /**
     * 1 1 1
     * 1 1 2
     * 1 2 1 산
     * 2 1 1
     * 1 2 2
     * 2 1 2
     * 2 2 1
     * 2 2 2
     *
     *
     */
}
