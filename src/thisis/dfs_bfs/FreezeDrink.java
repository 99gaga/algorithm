package thisis.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 음료수 얼려 먹기
 * n * m 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
 * 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
 * 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하라.
 */
public class FreezeDrink {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] box = new int[n][m];

        for (int row = 0; row < n; row++) {
            String[] isEmpty = br.readLine().split("");

            for (int col = 0; col < m; col++) {
                box[row][col] = Integer.parseInt(isEmpty[col]);
            }
        }

        int cnt = 0;
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {
                if (box[row][col] == 0) {
                    cnt++;
                    dfs(row, col, box);
                }
            }
        }

        System.out.println("result = " + cnt);
    }

    private static void dfs(int row, int col, int[][] box) {
        box[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int tempX = row + dx[i];
            int tempY = col + dy[i];

            if (tempX>=0 && tempY>=0 && tempX<box.length && tempY<box[0].length) {
                if (box[tempX][tempY] == 0) {
                    dfs(tempX, tempY, box);
                }
            }
        }
    }
}
