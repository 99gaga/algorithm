package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2636
 * 치즈
 */
public class boj2636 {

    private static final int[][] move = new int[][]{
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited;
        int hour = 0, cnt;
        while (true) {
            visited = new boolean[row][col];
            hour++;
            cnt = bfs(map, visited);

            int totalSum = Arrays.stream(map).flatMapToInt(Arrays::stream).sum();
            if (totalSum == 0) {
                break;
            }
        }

        System.out.println(hour);
        System.out.println(cnt);
    }

    private static int bfs(int[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] position = q.poll();
            for (int i = 0; i < move.length; i++) {
                int nx = position[0] + move[i][0];
                int ny = position[1] + move[i][1];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        cnt++;
                    } else { // 0
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return cnt;
    }

}
