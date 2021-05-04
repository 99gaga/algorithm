package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 화장실의 규칙
 */
public class boj19640 {

    static class Employee implements Comparable<Employee> {
        int num;
        int day;
        int hurry;
        boolean isDeca;

        public Employee(int num, int day, int hurry, boolean isDeca) {
            this.num = num;
            this.day = day;
            this.hurry = hurry;
            this.isDeca = isDeca;
        }

        @Override
        public int compareTo(Employee o) {
            if (this.day != o.day) {
                return o.day - this.day;
            } else if (this.hurry != o.hurry) {
                return o.hurry - this.hurry;
            } else {
                return this.num - o.num;
            }
        }
    }

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 대기 사원의 수
        M = Integer.parseInt(st.nextToken()); // 새로운 줄의 수
        K = Integer.parseInt(st.nextToken()); // 화장실에 도착했을 때 자신의 앞에 서있던 사원의 수수

        // 초기화
        Queue<Employee>[] q = new Queue[M];
        for (int i=0; i<M; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            q[i%M].offer(new Employee(i%M, D, H, i == K)); // 직원 줄세우기
        }

        Queue<Employee> pq = new PriorityQueue<>(); // 맨 앞줄
        for (int i=0; i<M; i++) {
            if (!q[i%M].isEmpty()) {
                pq.offer(q[i%M].poll());
            }
        }

        int cnt = 0;
        while (true) {
            Employee employee = pq.poll();
            if (employee.isDeca) break;

            int num = employee.num; // 줄 번호
            if (!q[num].isEmpty()) {
                pq.offer(q[num].poll());
            }
            cnt++;
        }

        System.out.println(cnt);
    }

}
