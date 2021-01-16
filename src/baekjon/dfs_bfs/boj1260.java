package baekjon.dfs_bfs;

import java.io.IOException;
import java.util.*;

//DFS와 BFS
public class boj1260 {

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int v = scan.nextInt();

        boolean[][] graph = new boolean[n+1][n+1];
        visit = new boolean[n+1];

        //간선 입력
        for (int i=0; i<m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = graph[b][a] = true;
        }

        dfsSolution(graph, v, n);

        System.out.println();
        Arrays.fill(visit, false);

        bfsSolution(graph, v, n);

    }

    static void bfsSolution(boolean[][] graph, int v, int n) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(v);
        visit[v] = true;
        System.out.print(v + " ");

        while(!bfs.isEmpty()) {
            int out = bfs.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[out][i] && !visit[i]) {
                    bfs.offer(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    static void dfsSolution(boolean[][] graph, int v, int n) {
        visit[v] = true;
        System.out.print(v + " ");

        for (int i=1; i <= n; i++) {
            if (graph[v][i] && !visit[i]) {
                dfsSolution(graph, i, n);
            }
        }
    }

}
