package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(box, n, m);
        System.out.println(result);
    }

    private static int bfs(int[][] box, int n, int m) {
        Queue<Position> queue = new LinkedList<>();

        int zeroCnt = 0;
        //1을 모두 찾는다
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (box[i][j] == 1) {
                    queue.add(new Position(i, j));
                } else if (box[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }

        if (zeroCnt == 0) return 0; //처음부터 토마토가 모두 익어있을 경우

        //토마토 익히기
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;

            for (int i=0; i<4; i++) {
                int tempX = dx[i] + x;
                int tempY = dy[i] + y;

                if (tempX>=0 && tempY>=0 && tempX<n && tempY<m) {
                    if (box[tempX][tempY] == 0) {
                        box[tempX][tempY] = box[x][y] + 1;
                        queue.add(new Position(tempX, tempY));
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return checkDay(box, n, m); //day 계산
    }

    private static int checkDay(int[][] box, int n, int m) {
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                max = Math.max(max, box[i][j]);
            }
        }

        return max - 1;
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
