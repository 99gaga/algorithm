package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 회전 초밥
 */
public class boj15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가지 수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 초밥 쿠폰의 번호

        int[] belt = new int[n];
        int[] eat = new int[d + 1];
        for (int i=0; i<n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        // 맨 처음 부터 k개를 계산
        int cnt = 0;
        for (int i=0; i<k; i++) {
            if (eat[belt[i]] == 0) cnt++;
            eat[belt[i]]++;
        }
        int result = eat[c] == 0 ? cnt + 1 : cnt;

        for (int i=0; i<n; i++) { // 시작이 0부터 n-1까지 k씩
            if (--eat[belt[i % n]] == 0) cnt--; // 맨 앞 제거후 먹은 초밥의 종류가 0개라면 cnt--
            if (eat[belt[(i + k) % n]]++ == 0) cnt++; // 그 다음 것을 추가 후 먹은 초밥의 종류가 0개 였다면 cnt++
            result = Math.max(result, eat[c] == 0 ? cnt + 1 : cnt); // 최대값 갱신
        }

        System.out.println(result);
    }

}
