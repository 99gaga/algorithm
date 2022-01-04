package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 */
public class boj1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> smallPq = new PriorityQueue<>((a, b) -> b - a); // 8 5 4 3 2 1
        Queue<Integer> bigPq = new PriorityQueue<>(); // 6 7 8 9 10

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (smallPq.size() == bigPq.size()) {
                if (!smallPq.isEmpty() && smallPq.peek() > number) {
                    bigPq.offer(smallPq.poll());
                    smallPq.offer(number);
                } else {
                    bigPq.offer(number);
                }
                System.out.println(bigPq.peek());
            } else {
                if (bigPq.peek() < number) {
                    smallPq.offer(bigPq.poll());
                    bigPq.offer(number);
                } else {
                    smallPq.offer(number);
                }
                System.out.println(smallPq.peek());
            }
        }
    }

}
