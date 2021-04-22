package thisis.graph;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전보 {

    static class Node implements Comparable<Node> {
        int num, cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int n, m, c;
    public static List<List<Node>> graph = new ArrayList<>();
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = new int[n+1];

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, z));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(c);

        int count = 0;
        int maxCost = 0;
        for (int i=1; i<=n; i++) {
            if (d[i] != Integer.MAX_VALUE) {
                count++;
                maxCost = Math.max(maxCost, d[i]);
            }
        }

        System.out.println(count - 1 + " " + maxCost);
    }

    private static void dijkstra(int c) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));
        d[c] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curCost = node.cost;
            int now = node.num;

            if (d[now] < curCost) continue;

            for (int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).cost;

                if (cost < d[graph.get(now).get(i).num]) {
                    d[graph.get(now).get(i).num] = cost;
                    pq.offer(new Node(graph.get(now).get(i).num, cost));
                }
            }
        }
    }

}
