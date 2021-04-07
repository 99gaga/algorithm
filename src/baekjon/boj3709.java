package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 레이저빔은 어디로
 */
public class boj3709 {

    static int n, r;
    static boolean[][][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 위, 오른쪽 아래 왼쪽
    static int[] dy = {0, 1, 0, -1}; // 0, 1, 2, 3

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            String[] inputNR = br.readLine().split(" ");

            n = Integer.parseInt(inputNR[0]);
            r = Integer.parseInt(inputNR[1]);

            board = new boolean[n + 2][n + 2][5]; // 0: 거울이 있는지 1, 2, 3, 4: 동서남북 어느쪽으로 부터 방문을 했는지?

            for (int j = 0; j < r; j++) {
                String[] inputXY = br.readLine().split(" ");
                int x = Integer.parseInt(inputXY[0]);
                int y = Integer.parseInt(inputXY[1]);
                board[x][y][4] = true;
            }

            String[] inputXY = br.readLine().split(" ");
            int startX = Integer.parseInt(inputXY[0]);
            int startY = Integer.parseInt(inputXY[1]);

            int dir = getStartDirection(startX, startY);

            bfs(startX, startY, dir);
        }
    }

    private static int getStartDirection(int startX, int startY) {
        int dir = 0;

        if (startX == 0) dir = 2;
        else if (startY == 0) dir = 1;
        else if (startY == n + 1) dir = 3;

        return dir;
    }

    private static void bfs(int startX, int startY, int direction) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{startX, startY});

        boolean flag = false;

        while (!q.isEmpty()) {
            int[] position = q.poll();
            int x = position[0];
            int y = position[1];

            if (x == 0 || y == 0 || x == n + 1 || y == n + 1) {
                if (flag) {
                    System.out.println(x + " " + y);
                    return;
                }
                flag = true;
            }

            int nextX = x + dx[direction]; // 다음 x 위치
            int nextY = y + dy[direction]; // 다음 y 위치

            if (!board[nextX][nextY][4]) {
                q.offer(new int[]{nextX, nextY});
            } else { // 거울을 만나면 돌기

                if (board[nextX][nextY][direction]) { // 무한루프
                    System.out.println(0 + " " + 0);
                    return;
                }
                q.offer(new int[]{nextX, nextY});
                board[nextX][nextY][direction] = true;
                direction = (direction + 1) % 4; // 오른쪽으로 돈다
            }

        }
    }

}
