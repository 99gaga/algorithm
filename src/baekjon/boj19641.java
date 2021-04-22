package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 중첩 집합 모델
 */
public class boj19641 {

    static class Node {
        int number;
        Queue<Node> link;
        int left;
        int right;

        public Node(int number) {
            this.number = number;
            link = new PriorityQueue<>((a, b) -> a.number - b.number);
        }
    }

    static int n;
    static int rootNode;
    static Node[] nodes;
    static int count = 1;
    static boolean[] visitedNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 정점의 개수
        nodes = new Node[n + 1]; // 1~n 번 노드까지
        visitedNode = new boolean[n + 1];
        for (int i=1; i<=n; i++) { // 초기화
            nodes[i] = new Node(i);
        }
        for (int i=1; i<=n; i++) {
            String[] input = br.readLine().split(" ");

            int nodeNum = Integer.parseInt(input[0]); // 해당 노드
            for (int j=1; j<input.length; j++) {
                int linkNode = Integer.parseInt(input[j]);
                if (linkNode == -1) break;
                nodes[nodeNum].link.offer(nodes[linkNode]); // 해당 노드에 연결된 노드
            }
        }
        rootNode = Integer.parseInt(br.readLine()); // 루트 노드

        // 입력

        searchNode(rootNode);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            sb.append(nodes[i].number).append(" ")
                    .append(nodes[i].left).append(" ")
                    .append(nodes[i].right).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void searchNode(int rootNode) {

        nodes[rootNode].left = count++;
        visitedNode[rootNode] = true;

        Queue<Node> linkedNode = nodes[rootNode].link;
        int size = linkedNode.size();
        for (int i=0; i<size; i++) {
            Node node = linkedNode.poll();
            if (!visitedNode[node.number]) {
                searchNode(node.number);
            }
        }

        nodes[rootNode].right = count++;
    }

}
