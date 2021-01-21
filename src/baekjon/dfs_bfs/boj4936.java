package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//섬의 개수
public class boj4936 {

    static int[] dx = {0, 0, 1, -1, 1, -1,  1, -1};
    static int[] dy = {-1, 1, 0, 0, -1 , 1, 1, -1};
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            int[][] island = new int[h][w];
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j=0; j<w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (island[i][j] == 1) {
                        cnt++;
                        dfs(i, j, island);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int row, int col, int[][] island) {
        island[row][col] = 0;

        for (int i=0; i<8; i++) {
            int tempX = dx[i] + row;
            int tempY = dy[i] + col;

            if (tempX>=0 && tempY>=0 && tempX<h && tempY<w && island[tempX][tempY] == 1) {
                dfs(tempX, tempY, island);
            }
        }
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int row, int col, int[][] island) {
        Queue<Location> queue = new LinkedList<>();

        queue.offer(new Location(row, col));
        island[row][col] = 0;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int x = location.x;
            int y = location.y;

            for (int i=0; i<dx.length; i++) {
                int tempX = dx[i] + x;
                int tempY = dy[i] + y;
                if (tempX>=0 && tempY>=0 && tempX<h && tempY<w) {
                    if (island[tempX][tempY]==1) {
                        bfs(tempX, tempY, island);
                    }
                }
            }
        }
    }
}
