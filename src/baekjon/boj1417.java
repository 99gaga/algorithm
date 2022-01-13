package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 국회의원 선거
 * https://www.acmicpc.net/problem/1417
 */
public class boj1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 후보의 수
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int dasom = Integer.parseInt(br.readLine());
        for (int i=0; i<n-1; i++) {
            int cnt = Integer.parseInt(br.readLine());
            q.offer(cnt);
        }

        int result = 0;
        if (q.size() != 0) {
            while (q.peek() >= dasom) {
                result++;
                dasom++;
                q.add(q.poll() - 1);
            }
        }
        System.out.println(result);
    }
}
