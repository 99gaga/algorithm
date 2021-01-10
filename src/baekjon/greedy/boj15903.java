package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

//카드 합체 놀이
public class boj15903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Long> card = new PriorityQueue<>();

        String[] input = br.readLine().split(" ");
        Long n = Long.parseLong(input[0]);
        Long m = Long.parseLong(input[1]);

        String[] cardNum = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            card.add(Long.parseLong(cardNum[i]));
        }

        for (int i=0; i<m; i++) {
            long cardSum = card.poll() + card.poll();
            card.add(cardSum);
            card.add(cardSum);
        }

        long sum = 0;
        while (!card.isEmpty()) {
            sum += card.poll();
        }
        System.out.println(sum);
    }
}
