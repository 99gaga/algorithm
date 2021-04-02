package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {

    @Test
    void test() {
        Assertions.assertEquals(9, solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        // 현재 시간에서 요청된 시간보다 작은 것중에 제일 소요시간이 작은 것을 선택하면 최소시간이 걸린다.
        // 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 먼저 요청 순서대로 정렬
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //요청 순서대로 처리함

        int idx = 0;
        int cnt = 0;
        int time = 0;
        while (cnt < jobs.length) {

            while (idx < jobs.length && jobs[idx][0] <= time) { // time보다 적으면 다넣는다.
                q.offer(jobs[idx++]);
            }

            if (!q.isEmpty()) {
                int[] job = q.poll();
                time += job[1];
                answer += time - job[0];
                cnt++;
            } else {
                time = jobs[idx][0]; // 아무것도 없으면 요청이 제일 빠른 것
            }
        }


        return answer / jobs.length;
    }
}
