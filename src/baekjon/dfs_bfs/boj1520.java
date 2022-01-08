package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막 길
 * https://www.acmicpc.net/problem/1520
 */
public class boj1520 {

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int result = searchRoute(0, 0, maps, dp);
        System.out.println(result);
    }

    public static int searchRoute(int row, int col, int[][] maps, int[][] dp) {
        if (row == maps.length - 1 && col == maps[0].length - 1) {
            return 1;
        }package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막 길
 * https://www.acmicpc.net/problem/1520
 */
        public class boj1520 {

            static int[] dx = new int[]{0, 0, -1, 1};
            static int[] dy = new int[]{-1, 1, 0, 0};

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                int[][] maps = new int[n][m];
                int[][] dp = new int[n][m];
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < m; j++) {
                        maps[i][j] = Integer.parseInt(st.nextToken());
                        dp[i][j] = -1;
                    }
                }

                int result = searchRoute(0, 0, maps, dp);
                System.out.println(result);
            }

            public static int searchRoute(int row, int col, int[][] maps, int[][] dp) {
                if (row == maps.length - 1 && col == maps[0].length - 1) {
                    return 1;
                }
                if (dp[row][col] != -1) {
                    return dp[row][col];
                }

                int presentHigh = maps[row][col];
                dp[row][col] = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = row + dx[i];
                    int ny = col + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length
                            && presentHigh > maps[nx][ny]) {
                        dp[row][col] += searchRoute(nx, ny, maps, dp);
                    }
                }
                return dp[row][col];
            }
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int presentHigh = maps[row][col];
        dp[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length
                    && presentHigh > maps[nx][ny]) {
                dp[row][col] += searchRoute(nx, ny, maps, dp);
            }
        }
        return dp[row][col];
    }
}
