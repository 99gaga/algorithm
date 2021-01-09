package baekjon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//회의실 배정
public class boj1931 {

    final static int START_TIME = 0;
    final static int END_TIME = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //input
        int n = scan.nextInt();
        int[][] time = new int[n][2];
        for (int i=0; i<n; i++) {
            time[i][START_TIME] = scan.nextInt();
            time[i][END_TIME] = scan.nextInt();
        }

        //logic
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[END_TIME] == o2[END_TIME])
                    return o1[START_TIME] - o2[START_TIME];

                return o1[END_TIME] - o2[END_TIME];
            }
        });

        int cnt = 0;
        int endTime = 0;
        for (int i=0; i<n; i++) {
            if (endTime <= time[i][START_TIME]) {
                endTime = time[i][END_TIME];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
