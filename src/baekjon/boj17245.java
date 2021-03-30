package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17245 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] server = new int[n][n];

        long answer = 0;
        long totalCnt = 0;
        int start = 0;
        int end = 0;

        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                server[i][j] = Integer.parseInt(input[j]);
                totalCnt += server[i][j];

                if (server[i][j] > end) end = server[i][j];
            }
        }
        // 입력
        long target = totalCnt % 2 == 0 ? totalCnt / 2 : totalCnt / 2 + 1;

        while (end >= start) {

            int mid = (end + start) / 2;
            long serverCnt = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    serverCnt += Math.min(mid, server[i][j]);
                }
            }

            if (serverCnt >= target) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

}
