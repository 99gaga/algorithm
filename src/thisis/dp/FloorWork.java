package thisis.dp;

import java.util.Scanner;

/**
 * 바닥 공사
 * 가로의 길이가 N, 세로의 길이가 2인 직사각형 형태의 얇은 바닥이 있다.
 * 태일이는 이 얇은 바닥을 1 * 2 덮개, 2 * 1 덮개, 2 * 2 덮개를 이용해 채우고자 한다.
 * 이때 바닥을 채우는 모든 경우의 수를 구하는 프로그램을 작성하시오
 * 예를 들어 2 * 3 크기의 바닥을 채우는 경우의 수는 5가지이다.
 */
public class FloorWork {

    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796; // 마지막 한칸을 제외한 경우 + 2칸을 제외한 경우 * 2
        }

        System.out.println(d[n]);
    }
}
