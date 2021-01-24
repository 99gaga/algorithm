package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//미로탐색
public class boj2178 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String[] input2 = br.readLine().split("");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        bfs(0, 0, map, n, m, visit);

        System.out.println(map[n-1][m-1]);
    }

    private static void bfs(int row, int col, int[][] map, int n, int m, boolean[][] visit) {
        Queue<Position> queue = new LinkedList<>();

        visit[row][col] = true;
        queue.offer(new Position(row, col));

        while (!queue.isEmpty()) {
            Position poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i=0; i<4; i++) {
                int tempX = dx[i] + x;
                int tempY = dy[i] + y;

                if (tempX>=0 && tempY>=0 && tempX<n && tempY<m) {
                    if (map[tempX][tempY] == 1 && !visit[tempX][tempY]) {
                        map[tempX][tempY] = map[x][y] + 1;
                        queue.offer(new Position(tempX, tempY));
                    }
                }
            }
        }
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
