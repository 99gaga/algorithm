package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 가장먼노드 {

    @Test
    public void test() {
        Assertions.assertEquals(3, solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    static class Node {
        int num;
        List<Node> next;

        public Node(int num) {
            this.num = num;
            next = new ArrayList<>();
        }

        public void add (Node node) {
            next.add(node);
        }

    }


    public int solution(int n, int[][] edge) {
        int answer = 0;

        Node[] nodes = new Node[n+1];
        for (int num=1; num<=n; num++) {
            nodes[num] = new Node(num);
        }

        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];
            nodes[a].add(nodes[b]);
            nodes[b].add(nodes[a]);
        }


        answer = bfs(nodes, n);

        return answer;
    }

    public int bfs(Node[] nodes, int len) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[1]);

        int[] distance = new int[len+1];
        distance[1] = 1;
        int max = 0;
        while (!queue.isEmpty()) {
            Node fromNode = queue.poll();

            for (Node toNode : fromNode.next) {
                if (distance[toNode.num] == 0) {
                    distance[toNode.num] = distance[fromNode.num] + 1;
                    queue.add(toNode);
                    max = Math.max(max, distance[toNode.num]);
                }
            }
        }

        int cnt = 0;
        for (int dist : distance) {
            if (dist == max) {
                cnt++;
            }
        }

        return cnt;
    }
}
