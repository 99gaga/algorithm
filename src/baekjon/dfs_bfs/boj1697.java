package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//숨바꼭질
public class boj1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visit = new int[100001];

        int result = 0;

        if (n != k) {
            result = bfs(n, k, visit);
        }
        System.out.println(result);
    }

    private static int bfs(int n, int k, int[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i=0; i<3; i++) {
                int next = move(i, num);

                if (next == k) {
                    visit[next] = visit[num] + 1;
                    break;
                }

                if (next>=0 && next<100001 && visit[next] == 0) {
                    queue.add(next);
                    visit[next] = visit[num] + 1; // 카운트
                }
            }

            if (visit[k] != 0) break;
        }

        return visit[k];
    }

    private static int move(int i, int n) {
        if (i == 0) {
            return n - 1;
        } else if(i == 1) {
            return n + 1;
        } else {
            return n * 2;
        }
    }
}
