package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//빙산
public class boj2573 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] icebergMap = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                icebergMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int icebergCnt = 0;
        int year = -1;
        while (icebergCnt < 2) {

            icebergCnt = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {

                    if (icebergMap[i][j] > 0 && !visit[i][j]) {
                        icebergCnt++;
                        dfs(i, j, icebergMap, visit, n, m);
                    }
                }
            }

            if (icebergCnt == 0)  break;

            //false 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(visit[i], false);
            }
            year++; //1년 증가
        }

        if (icebergCnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(year);
        }
    }

    private static void dfs(int row, int col, int[][] icebergMap, boolean[][] visit, int n, int m) {
        visit[row][col] = true;

        int line = 0;
        for (int i=0; i<4; i++) {
            int tempX = dx[i] + row;
            int tempY = dy[i] + col;

            if (tempX>=0 && tempY>=0 && tempX<n && tempY<m) {
                if (icebergMap[tempX][tempY] == 0 && !visit[tempX][tempY]) {
                    line++;
                } else if (!visit[tempX][tempY] && icebergMap[tempX][tempY]>0) {
                    dfs(tempX, tempY, icebergMap, visit, n, m);
                }
            }
        }

        icebergMap[row][col] -= line;
        if (icebergMap[row][col] < 0) {
            icebergMap[row][col] = 0;
        }
    }
}
