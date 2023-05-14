package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42892
public class 길찾기게임 {

    @Test
    public void test() {
        Assertions.assertArrayEquals(
                new int[][]{
                        {7, 4, 6, 9, 1, 8, 5, 2, 3},
                        {9, 6, 5, 8, 1, 4, 3, 2, 7}
                },
                solution(
                        new int[][]{
                                {5, 3}, {11, 5}, {13, 3}, {3, 5},
                                {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
                        }
                )
        );
    }

    class Node {
        int x;
        int y;
        int number;
        Node left;
        Node right;

        public Node(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        public void insertNode(Node node) {
            boolean isLeft = this.x > node.x;
            if (isLeft) {
                if (left == null) {
                    this.left = node;
                } else {
                    this.left.insertNode(node);
                }
            } else {
                if (right == null) {
                    this.right = node;
                } else {
                    this.right.insertNode(node);
                }
            }
        }

        public List<Integer> getPostOrder() {
            List<Integer> order = new ArrayList<>();
            if (this.left != null) {
                order.addAll(this.left.getPostOrder());
            }
            if (this.right != null) {
                order.addAll(this.right.getPostOrder());
            }
            order.add(this.number);
            return order;
        }

        public List<Integer> getPreOrder() {
            List<Integer> order = new ArrayList<>();
            order.add(this.number);
            if (this.left != null) {
                order.addAll(this.left.getPreOrder());
            }
            if (this.right != null) {
                order.addAll(this.right.getPreOrder());
            }
            return order;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            if (n1.y == n2.y) {
                return n1.x - n2.x;
            }
            return n2.y - n1.y;
        });

        for (int i = 0; i < nodeinfo.length; i++) {
            pq.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        Node root = pq.poll();
        while (!pq.isEmpty()) {
            root.insertNode(pq.poll());
        }

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = root.getPreOrder().stream().mapToInt(Integer::intValue).toArray();
        answer[1] = root.getPostOrder().stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

}
