package baekjon.greedy;

import java.util.Scanner;

// 동전 0
public class boj11047 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 입력
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] moneys = new int[n];
        for (int i=0; i<n; i++) {
            moneys[i] = scan.nextInt();
        }

        int cnt = getMoneyCount(n, k, moneys);

        System.out.println(cnt);
    }

    private static int getMoneyCount(int n, int k, int[] moneys) {
        int cnt = 0;

        while (k != 0) {
            int money = moneys[--n];
            int moneyCnt = k/money;
            if (moneyCnt > 0) {
                cnt += moneyCnt;
                k %= money;
            }
        }

        return cnt;
    }
}
