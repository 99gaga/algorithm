package baekjon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1072
public class boj1072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]); // 게임 횟수 x
        int y = Integer.parseInt(input[1]); // 이긴 게임 y
        int z = getWinPercent(x, y);

        int left = 0, right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getWinPercent(x + mid, y + mid) != z) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right == 1e9 ? -1 : right + 1);
    }

    private static int getWinPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
