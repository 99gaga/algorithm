package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 놀이공원
 */
public class boj2594 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> works = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String[] work = br.readLine().split(" ");
            int start = Integer.parseInt(work[0].substring(0, 2)) * 60 + Integer.parseInt(work[0].substring(2)) - 10;
            int end = Integer.parseInt(work[1].substring(0, 2)) * 60 + Integer.parseInt(work[1].substring(2)) + 10;
            works.add(new int[]{start, end});
        }
        works.add(new int[]{22 * 60, 22 * 60});
        works.sort((a, b) -> a[0] - b[0]);

        int criteria = 10 * 60; // 10시
        int max = 0;
        for (int[] work : works) {
            int start = work[0];
            int end = work[1];
            max = Math.max(max, start - criteria);
            criteria = Math.max(end, criteria);
        }
        System.out.println(max);
    }

}
