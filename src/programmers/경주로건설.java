package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {

    @Test
    void test() {
        Assertions.assertEquals(900, solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        Assertions.assertEquals(3800, solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}}));
    }

    static class Point {
        int x, y, cost, dir;

        public Point(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

    // 위 아래 왼쪽 오른쪽 - (0, 1, 2, 3)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int answer = 0;

        answer = bfs(0, 0, board, board.length);

        return answer;
    }

    private int bfs(int x, int y, int[][] board, int n) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y,0,1)); // 왼쪽
        q.add(new Point(x, y,0,3)); // 오른쪽
        board[x][y] = 1;

        int result = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == n - 1 && point.y == n - 1) {
                result = Math.min(result, point.cost);
                continue;
            }

            for (int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] != 1) {
                    int newCost = 0;

                    if (point.dir == i) {
                        newCost = point.cost + 100;
                    } else {
                        newCost = point.cost + 600;
                    }

                    if (board[nx][ny] == 0 || board[nx][ny] >= newCost) {
                        board[nx][ny] = newCost;
                        q.add(new Point(nx, ny, newCost, i));
                    }
                }
            }

        }

        return result;
    }

}
