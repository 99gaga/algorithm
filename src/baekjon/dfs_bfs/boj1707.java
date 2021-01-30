package baekjon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이분 그래프
public class boj1707 {

    static boolean validGraph;

    static class Node {
        int num;
        int color = 0; // no color: 0, color1: 1, color2: -1,
        List<Node> nextNode;

        public Node(int num) {
            this.num = num;
            nextNode = new ArrayList<>();
        }

        public void add(Node node) {
            nextNode.add(node);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        int v, e; // v: 정점의 개수, e: 간선의 개수

        for (int test = 0; test < testCase; test++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            Node[] nodes = new Node[v+1];

            for (int num = 1; num <= v; num++) {
                nodes[num] = new Node(num);
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // a Node
                int b = Integer.parseInt(st.nextToken()); // b Node

                nodes[a].add(nodes[b]);
                nodes[b].add(nodes[a]);
            }

            validGraph = true;

            for (int num = 1; num <= v; num++) {
                if (!validGraph) break;

                if (nodes[num].color == 0) {
                    dfs(nodes, num, 1);
                }
            }

            String result = validGraph ? "YES" : "NO";

            System.out.println(result);
        }
    }

    private static void dfs(Node[] nodes, int num, int color) {

        nodes[num].color = color;
        int nextColor = -color;

        for (Node node : nodes[num].nextNode) {

            if (node.color == 0) {
                dfs(nodes, node.num, nextColor);
            } else if (node.color == color) {
                validGraph = false;
                return;
            }
        }
    }
}
