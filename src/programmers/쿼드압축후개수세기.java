package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 쿼드압축후개수세기 {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{4, 9}, solution(new int[][]{
                {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}
        }));

        Assertions.assertArrayEquals(new int[]{10, 15}, solution(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}
        }));
    }

    int[] numberCounter;

    public int[] solution(int[][] arr) {

        numberCounter = new int[2];
        compression(arr, arr.length, 0, 0);

        return numberCounter;
    }

    public void compression(int[][] arr, int n, int row, int col) {

        if (n == 1) {
            numberCounter[arr[row][col]]++;
            return;
        }

        if (isValid(arr, n, row, col)) return;

        int divide = n / 2;
        compression(arr, divide, row, col);
        compression(arr, divide, row, col+n/2);
        compression(arr, divide, row+n/2, col);
        compression(arr, divide, row+n/2, col+n/2);
    }

    public boolean isValid(int[][] arr, int n, int row, int col) {

        int standard = arr[row][col];

        for (int i=row; i<row+n; i++) {
            for (int j=col; j<col+n; j++) {
                if (arr[i][j] != standard) return false;
            }
        }

        numberCounter[standard]++;

        return true;
    }
}
