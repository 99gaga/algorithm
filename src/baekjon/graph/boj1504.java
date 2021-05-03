package baekjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정한 최단 경로
 */
public class boj1504 {

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static final int INF = 10000000;
    static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 초기화
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 반드시 거쳐야 하는 두 정점의 번호
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0, result2 = 0;

        int v1v2 = dijkstra(v1, v2);
        result1 = dijkstra(1, v1) + v1v2 + dijkstra(v2, N);
        result2 = dijkstra(1, v2) + v1v2 + dijkstra(v1, N);

        if (result1 >= INF && result2 >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(result1, result2));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        boolean[] visited = new boolean[N+1];
        int[] d = new int[N+1];
        Arrays.fill(d, INF);
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node from = pq.poll();

            if (from.num == end) break;

            if (visited[from.num]) continue;
            visited[from.num] = true;

            List<Node> nodes = graph.get(from.num);
            for (Node to : nodes) {
                int cost = d[from.num] + to.weight;
                if (cost < d[to.num]) {
                    d[to.num] = cost;
                    pq.offer(new Node(to.num, cost));
                }
            }
        }

        return d[end];
    }

}
