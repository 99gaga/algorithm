package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//적록색약
public class boj10026 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] color = new char[n][n];
        char[][] blind = new char[n][n];
        for (int i=0; i<n; i++) {
            color[i] = br.readLine().toCharArray();
            for (int j=0; j<n; j++) {
                if (color[i][j] == 'G') {
                    blind[i][j] = 'R';
                } else {
                    blind[i][j] = color[i][j];
                }
            }
        }

        int colorCnt = 0, blindCnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (color[i][j] != 'X') {
                    colorCnt++;
                    dfs(i, j, color);
                }

                if (blind[i][j] != 'X') {
                    blindCnt++;
                    dfs(i, j, blind);
                }
            }
        }

        System.out.println(colorCnt + " " + blindCnt);
    }

    private static void dfs(int row, int col, char[][] map) {
        char original = map[row][col];
        map[row][col] = 'X';

        for (int i=0; i<4; i++) {
            int tempX = dx[i] + row;
            int tempY = dy[i] + col;

            if (tempX>=0 && tempY>=0 && tempX<map.length && tempY<map.length) {
                if (original == map[tempX][tempY]) {
                    dfs(tempX, tempY, map);
                }
            }
        }
    }
}
