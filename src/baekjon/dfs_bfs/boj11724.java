package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연결 요소의 개수
public class boj11724 {

    static boolean[][] node;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); //정점의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수
        visit = new boolean[n+1];
        node = new boolean[n+1][n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[x][y] = node[y][x] = true;
        }

        int cnt = getConnectCount(n);

        System.out.println(cnt);
    }

    private static int getConnectCount(int n) {
        int cnt = 0;

        for (int i=1; i<=n; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(i, n);
            }
        }
        return cnt;
    }

    static void dfs(int x, int n) {
        visit[x] = true;

        for (int i=1; i<=n; i++) {
            if (node[x][i] && !visit[i]) {
                dfs(i, n);
            }
        }
    }
}
