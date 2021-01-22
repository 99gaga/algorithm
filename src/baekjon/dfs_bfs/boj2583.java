package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//영역 구하기
public class boj2583 {

    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] paper = new int[m][n];

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());

            for (int row=ay; row<by; row++) {
                for (int col=ax; col<bx; col++) {
                    paper[row][col] = 1;
                }
            }
        }

        List<Integer> result = logic(m, n, paper);

        Collections.sort(result);
        System.out.println(cnt);
        result.forEach(x -> System.out.print(x + " "));
    }

    static List<Integer> logic(int m, int n, int[][] paper) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i< m; i++) {
            for (int j = 0; j< n; j++) {
                if (paper[i][j] == 0) {
                    result.add(0);
                    cnt++;
                    dfs(i, j, paper, m, n, result);
                }
            }
        }
        return result;
    }

    static void dfs(int i, int j, int[][] paper, int m, int n, List<Integer> result) {
        paper[i][j] = 1;
        result.set(cnt-1, result.get(cnt-1) + 1);

        for (int c=0; c<4; c++) {
            int tempX = dx[c] + i;
            int tempY = dy[c] + j;

            if (tempX>=0 && tempY>=0 && tempX<m && tempY<n && paper[tempX][tempY] == 0) {
                dfs(tempX, tempY, paper, m, n, result);
            }
        }
    }
}
