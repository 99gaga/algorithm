package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 배달 {

    @Test
    public void test() {
        Assertions.assertEquals(4, solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
        Assertions.assertEquals(4, solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<Node>> map = new ArrayList<>();


        for (int i=0; i<=N; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] info : road) {
            map.get(info[0]).add(new Node(info[1], info[2]));
            map.get(info[1]).add(new Node(info[0], info[2]));
        }

        int[] minTimes = new int[N + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);

        getMinTime(1, map, minTimes);

        for (int i=1; i<=N; i++) {
            if (minTimes[i] <= K) answer++;
        }

        return answer;
    }

    public void getMinTime(int start, List<List<Node>> map, int[] minTimes) {
        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        minTimes[start] = 0;

        while (!pq.isEmpty()) {
            Node from = pq.poll();
            int time = from.time; // 현재 마을까지 걸리는 시간
            int idx = from.idx; // 현재 마을

            if (minTimes[idx] < time) continue;

            for (int i=0; i<map.get(idx).size(); i++) {
                Node to = map.get(idx).get(i);
                int cost = to.time + minTimes[idx];

                if (cost < minTimes[to.idx]) {
                    minTimes[to.idx] = cost;
                    pq.offer(new Node(to.idx, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    int idx;
    int time;

    public Node(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }

    @Override
    public int compareTo(Node other) {
        return this.time - other.time;
    }
}


