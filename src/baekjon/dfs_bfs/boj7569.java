package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토2
public class boj7569 {

    final static int[] dx = { -1, 1, 0, 0, 0, 0 };
    final static int[] dy = { 0, 0, -1, 1, 0, 0 };
    final static int[] dz = { 0, 0, 0, 0, -1, 1 };

    static class Position {
        int x, y, z;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][][] box = new int[k][n][m];

        for (int i=0; i<k; i++) {
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z=0; z<m; z++) {
                    box[i][j][z] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int result = bfs(box, k, n, m);
        System.out.println(result);
    }

    private static int bfs(int[][][] box, int k, int n, int m) {
        Queue<Position> queue = new LinkedList<>();

        boolean isRipe = ripeTomato(box, k, n, m, queue);
        if (!isRipe) return 0;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;
            int z = position.z;

            for (int i=0; i<6; i++) {
                int tempX = dx[i] + x;
                int tempY = dy[i] + y;
                int tempZ = dz[i] + z;

                if (tempX>=0 && tempY>=0 && tempZ>=0 && tempX<k && tempY<n && tempZ<m) {
                    if (box[tempX][tempY][tempZ] == 0) {
                        box[tempX][tempY][tempZ] = box[x][y][z] + 1;
                        queue.add(new Position(tempX, tempY, tempZ));
                    }
                }
            }

            print(box, k, n, m);
        }



        for (int x=0; x<k; x++) {
            for (int y=0; y<n; y++) {
                for (int z=0; z<m; z++) {
                    if (box[x][y][z] == 0) return -1;
                }
            }
        }

        return checkMaxDay(box, k, n, m);
    }

    private static void print(int[][][] box, int k, int n, int m) {
        for (int x = 0; x< k; x++) {
            for (int y = 0; y< n; y++) {
                for (int z = 0; z< m; z++) {
                    System.out.print(box[x][y][z]);
                }
                System.out.println();
            }
            System.out.println("-----------------------");
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private static int checkMaxDay(int[][][] box, int k, int n, int m) {
        int max = 0;
        for (int x = 0; x< k; x++) {
            for (int y = 0; y< n; y++) {
                for (int z = 0; z< m; z++) {
                    max = Math.max(max, box[x][y][z]);
                }
            }
        }

        return max-1;
    }

    private static boolean ripeTomato(int[][][] box, int k, int n, int m, Queue<Position> queue) {
        boolean isRipe = false;
        for (int x = 0; x< k; x++) {
            for (int y = 0; y< n; y++) {
                for (int z = 0; z< m; z++) {
                    if (box[x][y][z] == 1) {
                        queue.add(new Position(x, y, z));
                    } else if (box[x][y][z] == 0) {
                        isRipe = true;
                    }
                }
            }
        }

        return isRipe;
    }
}
