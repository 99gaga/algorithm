package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 삼각 달팽이
 */
public class TriangleSnail {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{1, 2, 9, 3, 10, 8, 4, 5, 6, 7}, solution(4));
        Assertions.assertArrayEquals(new int[]{1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9}, solution(5));
        Assertions.assertArrayEquals(new int[]{1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11}, solution(6));
    }

    private int[] solution(int n) {
        int[][] arr = new int[n][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }

        int maxValue = n * (n + 1) / 2;
        int[] answer = new int[maxValue];

        int i = 0, j = 0, k = 1;
        arr[i][j] = k;

        while (k < maxValue) {

            while (i + 1 < n && arr[i + 1][j] == 0) {
                arr[++i][j] = ++k;
            }

            while (j + 1 < arr[i].length && arr[i][j + 1] == 0) {
                arr[i][++j] = ++k;
            }

            while (i - 1 > 0 && j - 1 > 0 && arr[i - 1][j - 1] == 0) {
                arr[--i][--j] = ++k;
            }
        }

        int idx = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}
