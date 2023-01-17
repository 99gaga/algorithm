package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 부모 찾기
public class boj11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // node 개수
        int n = Integer.parseInt(st.nextToken());

        // 초기화
        int[] parentNode = new int[n];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
            parentNode[i] = -1;
        }

        // 간선 입력
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken()) - 1;
            int nodeB = Integer.parseInt(st.nextToken()) - 1;
            tree.get(nodeA).add(nodeB);
            tree.get(nodeB).add(nodeA);
        }

        // 큐를 이용한 순회
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int parent = q.poll();
            for (int node : tree.get(parent)) {
                if (parentNode[node] == -1) {
                    q.add(node);
                    parentNode[node] = parent;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(parentNode[i] + 1);
        }
    }
}
