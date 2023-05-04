package baekjon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1654
public class boj1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[0]); // 랜선의 개수 K
        int n = Integer.parseInt(input[1]); // 필요한 랜선의 개수 N
        int[] lanLength = new int[k];

        int maxLength = 0;
        for (int i = 0; i < k; i++) {
            lanLength[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, lanLength[i]);
        }

        int min = 0, mid = 0, max = maxLength;
        while (min < max) {
            mid = (min + max) / 2;
            long cnt = 0;
            for (int length : lanLength) {
                cnt += (length / mid);
            }

            if (cnt < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
