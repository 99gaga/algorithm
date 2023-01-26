package baekjon.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 효율적인 해킹
 *
 * 해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다.
 * 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
 * 이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
 * 이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
 */
public class boj1325 {

    static int[] computer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        computer = new int[N + 1];
        int max = Integer.MIN_VALUE;
        boolean[] visited;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, visited, list);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, computer[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (computer[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int start, boolean[] visited, ArrayList<Integer>[] list) {
        visited[start] = true;

        for (int node : list[start]) {
            if (!visited[node]) {
                computer[node]++;
                dfs(node, visited, list);
            }
        }
    }

}
