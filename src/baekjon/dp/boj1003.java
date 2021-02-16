package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 함수
 */
public class boj1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int n = Integer.parseInt(br.readLine());

        int num;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());

            int[] cnt = fibonacci(num);

            System.out.println(cnt[0] + " " + cnt[1]);
        }
    }

    private static int[] fibonacci(int num) {
        // 0 일때
        int zero = 1;
        int one = 0;
        int zero_plus_one = zero + one;

        /**
         * 규칙
         * n-1의 1은 n의 0의 호출수가 되고
         * n-1의 0과 1의 호출 합은 n의 1의 호출수가 된다.
         */

        for (int i = 0; i < num; i++) {
            zero = one;
            one = zero_plus_one;
            zero_plus_one = zero + one;
        }

        return new int[]{zero, one};
    }
}
