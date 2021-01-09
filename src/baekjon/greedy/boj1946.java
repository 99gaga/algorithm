package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//신입 사원
public class boj1946 {

    final static int FIRST_RANK = 0;
    final static int SECOND_RANK = 1;
    final static int EXAM_CASE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); //테스트 횟수
        int[] result = new int[t];
        int n;
        StringTokenizer st;

        for (int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            int[][] rank = new int[n][EXAM_CASE];
            for (int k=0; k<n; k++) {
                 st = new StringTokenizer(br.readLine());
                rank[k][FIRST_RANK] = Integer.parseInt(st.nextToken());
                rank[k][SECOND_RANK] = Integer.parseInt(st.nextToken());
            }

            result[i] = maxHire(rank, n);
        }

        for (int out : result) {
            System.out.println(out);
        }
    }

    private static int maxHire(int[][] rank, int n) {
        Arrays.sort(rank, (o1, o2) -> o1[FIRST_RANK] - o2[FIRST_RANK]);

        int max = 1;
        int standard = rank[0][SECOND_RANK];
        for (int i=1; i<n; i++) {
            if (rank[i][SECOND_RANK] < standard) {
                standard = rank[i][SECOND_RANK];
                max++;
            }
        }

        return max;
    }
}
