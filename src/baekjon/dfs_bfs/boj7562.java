package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//나이트의 이동
public class boj7562 {

    static final int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static final int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            int length = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Point destination = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int result = bfs(start, destination, length);
            System.out.println(result);
        }
    }

    private static int bfs(Point start, Point destination, int length) {

        int[][] board = new int[length][length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        board[start.row][start.col] = 1; // 출발 장소도 visit 처리하기 위해

        while (!queue.isEmpty()) {

            Point point = queue.poll();
            int row = point.row;
            int col = point.col;

            if (row == destination.row && col == destination.col) {
                break;
            }

            for (int i=0; i<8; i++) {
                int tempRow = row + dx[i];
                int tempCol = col + dy[i];


                if (tempRow < 0 || tempCol < 0 || tempRow >= length || tempCol >= length) {
                    continue;
                }

                if (board[tempRow][tempCol] == 0) {
                    board[tempRow][tempCol] = board[row][col] + 1;
                    queue.add(new Point(tempRow, tempCol));
                }
            }
        }

        //시작점을 1로 visit처리했기 때문에 결과에 -1 해줘야 한다.
        return board[destination.row][destination.col] - 1;
    }
}

class Point {

    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
