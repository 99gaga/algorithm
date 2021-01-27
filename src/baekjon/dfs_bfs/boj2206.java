package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class boj2206 {

    //상하좌우
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Position {
        int row;
        int col;
        int cnt;
        boolean crashSkill; //부수기 1회

        public Position(int row, int col, int cnt, boolean crashSkill) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.crashSkill = crashSkill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][][] visit = new boolean[n][m][2];

        for (int row=0; row<n; row++) {
            String[] inputMap = br.readLine().split("");
            for (int col = 0; col < m; col++) {
                map[row][col] = Integer.parseInt(inputMap[col]);
            }
        }
        //입력 끝

        System.out.println(bfs(map, n, m, visit));
    }

    private static int bfs(int[][] map, int n, int m, boolean[][][] visit) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1,true)); //(0,0) 벽부수기 1회

        while (!queue.isEmpty()) {
            Position position= queue.poll();

            if (position.row == n-1 && position.col == m-1) {
                return position.cnt;
            }

            for (int i=0; i<4; i++) {
                int tempRow = dx[i] + position.row;
                int tempCol = dy[i] + position.col;
                boolean tempCrash = position.crashSkill;
                int isCrash = tempCrash ? 0 : 1;

                if (tempRow>=0 && tempCol>=0 && tempRow<n && tempCol<m) { //범위 검사

                    if (!visit[tempRow][tempCol][isCrash]) {

                        if (map[tempRow][tempCol] == 0) { //이동할 수 있는 곳인지
                            visit[tempRow][tempCol][isCrash] = true;
                            queue.add(new Position(tempRow, tempCol, position.cnt+1, tempCrash));
                        } else if (tempCrash == true) { //벽이라면 부수기 1회가 있는지
                            queue.add(new Position(tempRow, tempCol, position.cnt+1, false));
                        }
                    }
                }
            }
        }

        return -1;
    }
}