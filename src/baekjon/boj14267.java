package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 회사 문화 1
 */
public class boj14267 {

    static List<Integer>[] members;
    static int[] praise;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        praise = new int[n + 1];
        members = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i=0; i<=n; i++) {
            members[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) continue;
            members[num].add(i);
        }

        // 직속 상사로부터 칭찬받을 직원번호 i, 칭찬의 수치 w
        for (int k=0; k<m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()); // 칭찬 받을 직원 번호
            int w = Integer.parseInt(st.nextToken());
            praise[i] += w;
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            sb.append(praise[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int num) {
        for (int next : members[num]) {
            praise[next] += praise[num];
            dfs(next);
        }
    }

}
