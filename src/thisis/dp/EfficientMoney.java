package thisis.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 효율적인 화폐 구성
 * N가지 종류의 화폐가 있다. 이 화페들의 개수를 최소한으로 이용해서 그 가치의 합이 M원이 되도록 하려고 한다.
 * 이때 각 화폐는 몇개라도 사용할 수 있으며 사용한 화폐의 구성은 같지만 순서만 다른 것은 같은 경우로 구분한다.
 * ex) 2원 3원 단위 화폐, 15원을 만드려면 3원 * 5, 5개
 * 불가능할 경우에는 -1을 출력
 */
public class EfficientMoney {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // 화폐의 종류
        int m = scan.nextInt(); // 목표 가치

        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = scan.nextInt();
        }

        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = money[i]; j <= m; j++) {
                if (d[j - money[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - money[i]] + 1);
                }
            }
        }

        if (d[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }
    }
}
