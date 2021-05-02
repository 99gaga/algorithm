package baekjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최단 경로
 */
public class boj1754 {

    static List<List<Node>> graph = new ArrayList<>();
    static int[] d;
    static final int INF = 10000000;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수 (1 ~ V)
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        // 초기화
        d = new int[V+1];
        Arrays.fill(d, INF);
        for (int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // u에서
            int v = Integer.parseInt(st.nextToken()); // v로 가는
            int e = Integer.parseInt(st.nextToken()); // 가중치 w
            graph.get(u).add(new Node(v, e));
        }

        boolean[] visited = new boolean[V+1];
        dijkstra(K, visited);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
            if (d[i] != INF) {
                sb.append(d[i]).append("\n");
            } else {
                sb.append("INF\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra(int startNode, boolean[] visited) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode, 0));
        d[startNode] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.num]) continue;
            visited[node.num] = true;

            List<Node> nodes = graph.get(node.num);
            for (Node to : nodes) {
                int cost = d[node.num] + to.weight;

                if (cost < d[to.num]) {
                    d[to.num] = cost;
                    pq.offer(new Node(to.num, cost));
                }
            }
        }
    }

}
