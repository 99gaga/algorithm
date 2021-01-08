package thisis.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCardGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int result = 0;

        // 행 * 열 크기 입력
        int n = scan.nextInt();
        int m = scan.nextInt();

        int x;
        for (int i=0; i<n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j=0; j<m; j++) {
                x = scan.nextInt();
                min = Math.min(min, x); //같은 행에서 가장 작은 수 찾기
            }
            result = Math.max(min, result); //행마다 가장 작은 수 중에서 가장 큰 수 찾기
        }

        System.out.println(result);
    }
}
