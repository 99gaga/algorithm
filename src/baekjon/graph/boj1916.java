package baekjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소비용 구하기
 */
public class boj1916 {

    static List<List<int[]>> map = new ArrayList<>();
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for (int i=0; i<=n; i++) {
            map.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(a).add(new int[]{b, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(d[end]);
    }

    private static void dijkstra(int start) {
        Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        pq.offer(new int[]{start, 0});
        d[start] = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int from = node[0];
            int cost = node[1];

            if (d[from] < cost) continue;

            List<int[]> lists = map.get(from);
            for (int[] to : lists) {
                int newCost = d[from] + to[1];
                if (newCost < d[to[0]]) {
                    d[to[0]] = newCost;
                    pq.offer(new int[]{to[0], newCost});
                }
            }
        }
    }

}
