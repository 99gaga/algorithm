package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 단어 변환
 */
public class TransWord {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solution(begin, target, words); // 4

        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        int result2 = solution(begin, target, words); // 0

        System.out.println(result + "\n" + result2);
    }

    static class Node {
        String word;
        int cnt;

        public Node(String next, int cnt) {
            this.word = next;
            this.cnt = cnt;
        }
    }

    private static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;

        Queue<Node> q = new LinkedList<>();
        boolean[] visits = new boolean[n];

        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.word.equals(target)) {
                answer = node.cnt;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visits[i] && isDiff(node.word, words[i])) {
                    visits[i] = true;
                    q.add(new Node(words[i], node.cnt + 1));
                }
            }
        }

        return answer;
    }

    private static boolean isDiff(String word, String des) {
        int cnt = 0;

        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) != des.charAt(i)) {
                cnt++;

                if (cnt > 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
