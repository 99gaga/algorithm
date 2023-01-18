package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [촌수 계산]
// 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때 두사람의 촌수를 계산하는 프로그램을 작성하시오.
public class boj2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 전체 사람의 수 n
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> relation = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            relation.add(new ArrayList<>());
        }
        // 촌수를 계산해야 하는 사이 두 사람
        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        // 부모 자식들 간의 관계의 개수 m
        int m = Integer.parseInt(br.readLine());
        // 앞 번호가 부모 뒷 번호가 자식을 의미
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation.get(x).add(y);
            relation.get(y).add(x);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{p1, 0}); // 사람, 촌수
        visited[p1] = true;

        int degree = -1; // 촌수
        while (!q.isEmpty()) {
            int[] data = q.poll();
            int person = data[0];
            int count = data[1];
            visited[person] = true;

            if (person == p2) {
                degree = count;
                break;
            }

            for (int son : relation.get(person)) {
                if (!visited[son]) {
                    q.add(new int[]{son, count + 1});
                }
            }
        }

        System.out.println(degree);
    }
}
