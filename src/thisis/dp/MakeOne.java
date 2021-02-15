package thisis.dp;

import java.util.Scanner;

/**
 * 1로 만들기
 * 정수 X가 주어질 때 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지이다.
 * <p>
 * - X가 5로 나누어 떨어지면, 5로 나눈다.
 * - X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * - X가 2로 나누어 떨어지면, 2로 나눈다.
 * - X에서 1을 뺀다.
 * <p>
 * 정수 X가 주어졌을 때, 연산 4개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 구해라.
 */
public class MakeOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int[] d = new int[30001];

        for (int i = 2; i < x + 1; i++) {

            d[i] = d[i-1] + 1;

            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);

            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);

            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }

        System.out.println(d[x]);
    }
}
