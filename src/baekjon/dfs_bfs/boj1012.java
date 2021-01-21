package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//유기농 배추
public class boj1012 {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); //테스트 케이스 개수


        for (int testCase=0; testCase<t; testCase++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]); //배추밭 가로길이
            int n = Integer.parseInt(input[1]); //배추밭 세로길이
            int k = Integer.parseInt(input[2]); //배추 개수
            int[][] field = new int[m][n];

            for (int i=0; i<k; i++) {
                String[] cabbage = br.readLine().split(" ");
                int x = Integer.parseInt(cabbage[0]);
                int y = Integer.parseInt(cabbage[1]);
                field[x][y] = 1;
            }
            //input------------------------------------------------
            int cnt = 0;

            for (int row=0; row<m; row++) {
                for (int col=0; col<n; col++) {
                    if (field[row][col] == 1) {
                        cnt++;
                        dfs(row, col, field, m, n);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int row, int col, int[][] field, int m, int n) {
        field[row][col] = 0;

        for (int i=0; i<4; i++) {
            int tempX = dx[i] + row;
            int tempY = dy[i] + col;

            if (tempX>=0 && tempY>=0 && tempX<m && tempY<n) {
                if (field[tempX][tempY] == 1) {
                    dfs(tempX, tempY, field, m, n);
                }
            }
        }
    }
}
