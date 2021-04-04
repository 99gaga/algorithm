package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 샤워실 바닥 깔기
 */
public class boj14600 {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, k);
        map = new int[size + 1][size + 1];
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        map[y][x] = -1;

        search(1, 1, size);

        print();

    }

    public static int number = 0;

    public static void search(int x, int y, int size) {
        number++;
        int halfSize = size / 2; // 4등분을 한다

        if (check(x, y, halfSize)) { // check(x, y, halfSize) 안에 배수구가 있는 지 확인하고 없으면 숫자로 채운다.
            map[x + halfSize - 1][y + halfSize - 1] = number;
        }
        if (check(x + halfSize, y, halfSize)) {
            map[x + halfSize][y + halfSize - 1] = number;
        }
        if (check(x, y + halfSize, halfSize)) {
            map[x + halfSize - 1][y + halfSize] = number;
        }
        if (check(x + halfSize, y + halfSize, halfSize)) {
            map[x + halfSize][y + halfSize] = number;
        }

        if (halfSize == 1) return; // 개수 한개씩 채울 때가 마지막

        search(x, y, halfSize);
        search(x + halfSize, y, halfSize);
        search(x, y + halfSize, halfSize);
        search(x + halfSize, y + halfSize, halfSize);
    }

    private static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }


    private static void print() {
        for (int i = map.length-1; i>0; i--) {
            for (int j = 1; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

