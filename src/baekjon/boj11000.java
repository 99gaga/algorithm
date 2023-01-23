package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 강의실 배정
 *
 * 수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
 * 김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
 * 참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
 * 수강신청 대충한 게 찔리면, 선생님을 도와드리자!
 */

public class boj11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 수업의 개수 n
        int[][] lectures = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // start time
            lectures[i][1] = Integer.parseInt(st.nextToken()); // end time
        }

        Arrays.sort(lectures, (l1, l2) -> {
            if (l1[0] == l2[0]) {
                return l1[1] - l2[1];
            }
            return l1[0] - l2[0];
        });

        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0][1]); // 가장 처음 시작하는 강의의 끝나는 시간

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= lectures[i][0]) {
                pq.poll();
            }
            pq.offer(lectures[i][1]);
        }

        System.out.println(pq.size());
    }

}
