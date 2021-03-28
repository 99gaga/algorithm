package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 인구 이동
public class boj16234 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int n, l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNLR = br.readLine().split(" ");
        n = Integer.parseInt(inputNLR[0]);
        l = Integer.parseInt(inputNLR[1]);
        r = Integer.parseInt(inputNLR[2]);

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            String[] population = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(population[j]);
            }
        }
        ////////////// 입력

        boolean isPopulationMove = false;
        int cnt = 0;
        while (true) {

            for (int x=0; x<n; x++) {
                for (int y=0; y<n; y++) {
                    if (!visited[x][y]) {
                        if (bfs(x, y)) isPopulationMove = true;
                    }
                }
            }

            if (isPopulationMove) {
                isPopulationMove = false;
                visited = new boolean[n][n];
                cnt++;
            } else {
                break;
            }

        }


        System.out.println(cnt);
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        q.offer(new int[]{x, y});

        int sum = 0;
        while (!q.isEmpty()) {
            int[] position = q.poll();
            int curX = position[0];
            int curY = position[1];

            union.add(new int[]{curX, curY});
            sum += map[curX][curY];
            visited[curX][curY] = true;

            for (int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX>=0 && nextY>=0 && nextX<n && nextY<n) {
                    if (!visited[nextX][nextY] && isValid(curX, curY, nextX, nextY)) {
                        q.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        if (union.size() > 1) {

            int populationMove = sum / union.size();
            for (int[] position : union) {
                map[position[0]][position[1]] = populationMove;
            }
            return true;
        }

        return false;
    }

    private static boolean isValid(int curX, int curY, int nextX, int nextY) {
        int diff = Math.abs(map[curX][curY] - map[nextX][nextY]);
        return l<=diff && diff<=r;
    }
}
