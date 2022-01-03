package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 안전 영역
 * https://www.acmicpc.net/problem/2468
 */
public class boj2468 {

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0,};

    public static void main(String[] args) throws IOException {
        Set<Integer> heightSet = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] heights = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(heights[j]);
                area[i][j] = height;
                heightSet.add(height);
            }
        }

        int maxCnt = 1;
        for (int waterHeight : heightSet) {
            boolean[][] visited = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (waterHeight < area[i][j] && !visited[i][j]) {
                        calcRegion(area, visited, i, j, waterHeight);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }

    private static void calcRegion(int[][] area, boolean[][] visited, int row, int col, int waterHeight) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < area.length && ny < area[0].length
                        && area[nx][ny] > waterHeight && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
