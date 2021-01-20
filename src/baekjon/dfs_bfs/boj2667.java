package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//단지 번호 붙이기
public class boj2667 {

    static int[][] home;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
    static int n, homeCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        home = new int[n][n];
        for (int i=0; i<n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0; j<n; j++) {
                home[i][j] = Integer.parseInt(String.valueOf(temp[j]));
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (home[i][j] == 1) {
                    result.add(homeCount++);
                    dfs(i, j, result);
                }
            }
        }
        Collections.sort(result);

        System.out.println(homeCount);
        result.forEach(System.out::println);
    }

    static void dfs(int x, int y, List<Integer> result) {
        home[x][y] = 0;
        result.set(homeCount-1, result.get(homeCount-1)+1);

        for (int i=0; i<4; i++) {
            int tempX = dx[i] + x;
            int tempY = dy[i] + y;

            if (tempX>=0 && tempY>=0 && tempX<n && tempY<n) {
                if (home[tempX][tempY] == 1) {
                    dfs(tempX, tempY, result);
                }
            }
        }
    }
}
