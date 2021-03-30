package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1941 {

    static char[][] map = new char[5][5];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static boolean[][] comb = new boolean[5][5];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i=0; i<25; i++) {
            comb[i/5][i%5] = true;
            combination(i, 1, 0);
            comb[i/5][i%5] = false;
        }

        System.out.println(answer);
    }

    private static void combination(int start, int cnt, int dasomCnt) {
        if (map[start/5][start%5] == 'S') {
            dasomCnt++;
        }

        if (cnt == 7) {
            if (dasomCnt >= 4) {
                visited = new boolean[5][5];
                bfs(start/5, start%5);
            }
            return;
        }

        for (int i=start + 1; i<25; i++) {
            comb[i/5][i%5] = true;
            combination(i, cnt+1, dasomCnt);
            comb[i/5][i%5] = false;
        }

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] position = q.poll();
            int curX = position[0];
            int curY = position[1];

            cnt++;
            if (cnt == 7) {
                answer++;
                return;
            }

            for (int i=0; i<4; i++) {
                int tempX = curX + dx[i];
                int tempY = curY + dy[i];

                if (tempX>=0 && tempY>=0 && tempX<5 && tempY<5) {
                    if (comb[tempX][tempY] && !visited[tempX][tempY]) {
                        visited[tempX][tempY] = true;
                        q.offer(new int[]{tempX, tempY});
                    }
                }
            }
        }
    }

}
