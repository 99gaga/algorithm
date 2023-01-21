package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 도서관
 *
 * 세준이는 도서관에서 일한다. 도서관의 개방시간이 끝나서 세준이는 사람들이 마구 놓은 책을 다시 가져다 놓아야 한다.
 * 세준이는 현재 0에 있고, 사람들이 마구 놓은 책도 전부 0에 있다.
 * 각 책들의 원래 위치가 주어질 때, 책을 모두 제자리에 놔둘 때 드는 최소 걸음 수를 계산하는 프로그램을 작성하시오.
 * 세준이는 한 걸음에 좌표 1칸씩 가며, 책의 원래 위치는 정수 좌표이다.
 * 책을 모두 제자리에 놔둔 후에는 다시 0으로 돌아올 필요는 없다. 그리고 세준이는 한 번에 최대 M권의 책을 들 수 있다.
 */
public class boj1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 책의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 책의 개수 m
        st = new StringTokenizer(br.readLine());
        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int position = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.abs(position));

            if (position < 0) {
                minusList.add(position * - 1);
            } else {
                plusList.add(position);
            }
        }

        plusList.sort(Collections.reverseOrder());
        minusList.sort(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < plusList.size(); i += m) {
            sum += plusList.get(i);
        }
        for (int i = 0; i < minusList.size(); i += m) {
            sum += minusList.get(i);
        }

        System.out.println(sum * 2 - max);
    }
}
