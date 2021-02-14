package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/14502
 * 백준 14502번 연구소
 * 1. 벽을 세울 3곳을 고른다.
 * 2. 바이러스를 퍼뜨린다.
 * 3. 안전영역을 구한다.
 */
public class boj14502 {

    static int n, m;
    static int[][] map;
    static int maxSafeArea = 0;
    static Queue<int[]> virusQueue;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]); // 세로
        m = Integer.parseInt(input[1]); // 가로
        map = new int[n][m];
        virusQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] mapInfo = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                int info = Integer.parseInt(mapInfo[j]);
                map[i][j] = info;

                if (info == 2) {
                    virusQueue.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0);

        System.out.println(maxSafeArea);
    }

    /**
     * 벽 세우기
     */
    private static void dfs(int start, int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i=start; i<n*m; i++) {
            int row = i / m;
            int col = i % m;

            if (map[row][col] == 0) {
                map[row][col] = 1;
                dfs(i+1,wallCount + 1);
                map[row][col] = 0;
            }
        }
    }

    /**
     * 바이러스 퍼뜨리기
     */
    private static void bfs() {
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        Queue<int[]> virus = new LinkedList<>();
        virus.addAll(virusQueue);

        while (!virus.isEmpty()) {
            int[] position = virus.poll();
            int x = position[0];
            int y = position[1];

            for (int i = 0; i < 4; i++) {
                int tempX = x + dx[i];
                int tempY = y + dy[i];

                if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < m) {
                    if (copyMap[tempX][tempY] == 0) {
                        copyMap[tempX][tempY] = 2;
                        virus.add(new int[]{tempX, tempY});
                    }
                }
            }
        }

        safeArea(copyMap);
    }

    /**
     * 안전영역 구하기
     */
    private static void safeArea(int[][] copyMap) {
        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, cnt);
    }
}
