package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//알파벳
public class boj1987 {

    static char[][] board;
//    static Stack<Character> visit = new Stack<>();
    static boolean[] visit = new boolean[26];
    static int max = 0;
    static int r, c;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        board = new char[c][];

        for (int i=0; i<r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int y, int x, int cnt) {
        visit[board[y][x] - 'A'] = true;

        for (int i=0; i<4; i++) {
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;
            if (moveX >=0 && moveY>=0 && moveX<c && moveY<r) {
                if (!visit[board[moveY][moveX] - 'A']) {
                    dfs(moveY, moveX, cnt + 1);
                }
            }
        }

        visit[board[y][x] - 'A'] = false;
        max = Math.max(max, cnt);
    }
}
