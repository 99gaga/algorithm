package thisis.dp;

import java.util.Scanner;

/**
 * 개미 전사
 * 개미 전사는 부족한 식량을 위해 메뚜기의 식량창고를 공격하려고 한다. 메뚜기 마을에는 여러 개의 식량창고가 일렬로 이어져 있다.
 * 각 식량창고에는 정해진 수의 식량을 저장하고 있으며 개미 전사는 식량창고를 선택적으로 약탈하여 식량을 빼앗을 예정이다.
 * 이때 메뚜기 정찰병들은 일직선상에 존재하는 식량창고 중에서 서로 인접한 식량창고가 공격받으면 바로 알아챌 수 있다.
 * 따라서 개미 전사가 정찰병에게 들키지 않고 식량창고를 약탈하기 위해서는 최소한 한 칸 이상 떨어진 식량창고를 약탈해야한다.
 * 개미 전사를 위해 식량창고 N개에 대한 정보가 주어졌을 때 얻을 수 있는 식량의 최댓값을 구하는 프로그램을 작성하시오.
 */
public class AntWarrior {

    public static int[] d = new int[100];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 창고의 개수
        int n = scan.nextInt();

        // 창고마다 식량의 개수
        int[] store = new int[n];
        for (int i = 0; i < n; i++) {
            store[i] = scan.nextInt();
        }

        d[0] = store[0];
        d[1] = Math.max(store[0], store[1]);
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + store[i]);
        }

        System.out.println(d[n - 1]);
    }
}
