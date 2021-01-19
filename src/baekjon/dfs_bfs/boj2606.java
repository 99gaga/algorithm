package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//바이러스
public class boj2606 {

    static int[][] node;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //computer
        int connectCount = Integer.parseInt(br.readLine()); //
        visit = new boolean[n+1];
        node = new int[n+1][n+1];

        for (int i=0; i<connectCount; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            node[x][y] = node[y][x] = 1;
        }

        int result = bfs(1);
        System.out.println(result);
    }

    static int bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        visit[num] = true;
        queue.offer(num);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y=1; y<node[x].length; y++) {
                if (node[x][y] == 1 && !visit[y]) {
                    visit[y] = true;
                    queue.offer(y);
                    System.out.println("y = " + y);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
