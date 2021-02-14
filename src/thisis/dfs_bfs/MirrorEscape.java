package thisis.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탈출
 * N * M 크기의 직사각형 형태의 미로에 갇혀 있다.
 * 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
 * 사람의 위치는 (1, 1)이고 미로의 출구는 (N, M)의 위치에 존재하며 한번에 한칸씩 이동할 수 있다.
 * 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다.
 * 미로는 반드시 탈출할 수 있는 형태로 제시된다.
 * 이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오. (첫칸, 마지막칸 포함)
 */
public class MirrorEscape {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            String[] isMonster = br.readLine().split("");

            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(isMonster[col]);
            }
        }



        int result = bfs(0, 0, map, visit);

        System.out.println("result = " + result);
    }

    private static int bfs(int row, int col, int[][] map, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        int N = map.length;
        int M = map[0].length;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];

            if (x == row - 1 && y == col - 1)
                break;

            for (int i = 0; i < 4; i++) {
                int tempX = x + dx[i];
                int tempY = y + dy[i];

                if (tempX < 0 || tempY < 0 || tempX >= N || tempY >= M)
                    continue;

                if (visit[tempX][tempY])
                    continue;

                map[tempX][tempY] = map[x][y] + 1;
                queue.add(new int[]{tempX, tempY});
                visit[tempX][tempY] = true;
            }
        }

        return map[N - 1][M - 1];
    }
}
