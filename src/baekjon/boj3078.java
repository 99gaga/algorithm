package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 좋은 친구
 */
public class boj3078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] nameLength = new int[n];
        for (int i=0; i<n; i++) {
            nameLength[i] = br.readLine().length();
        }

        long cnt = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 길이의 빈도수
        Queue<Integer> q = new LinkedList<>(); // 길이

        for (int len : nameLength) {
            if (map.containsKey(len)) {
                cnt += map.get(len);
            }

            if (q.size() == k) {
                int num = q.poll();
                int result = map.put(num, map.get(num) - 1);
                if (result == 0) {
                    map.remove(num);
                }
            }

            q.offer(len);
            map.put(len, map.getOrDefault(len, 0) + 1);
        }

        System.out.println(cnt);
    }

}
