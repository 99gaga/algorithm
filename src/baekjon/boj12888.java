package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 완전 이진 트리 도로 네트워크
 */
public class boj12888 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());

        long sum = 1;

        if (h % 2 == 0) { // 짝수
            long x = 2;
            h /= 2;
            for (int i=0; i<h; i++) {
                sum += x;
                x *= 4;
            }
        } else { // 홀수
            long x = 1;
            h /= 2;
            for (int i=0; i<h; i++) {
                x *= 4;
                sum += x;
            }
        }

        System.out.println(sum);
    }

}
