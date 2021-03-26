package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * i번째 있는 숫자는 p[i]번째로 가야한다. 즉 수열 p가 {2, 0, 1} 일때 0번째 숫자는 2번째로 1번쨰 숫자는 0번째로 2번쨰 숫자는 1번쨰로 가야한다.
 * 즉, 수열 p {2, 0, 1}은 이 숫자가 {0, 1, 2} 가 된다면 사기를 칠 수 있는 것이다. 수열 p를 {0, 1, 2, ...}로 만들어라
 * 하지만, 처음 p와 같다면 순환이라고 판단 -1을 출력한다.
 */
public class boj1091 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] original = new int[n]; // 맨처음 것
        int[] p = new int[n]; // 특정 순서로 보내야할 카드
        int[] s = new int[n]; // 섞는 방법
        int[] card = new int[n]; // 만들어야 하는 순서 카드

        String[] inputP = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            original[i] = p[i] = Integer.parseInt(inputP[i]);
            card[i] = i % 3;
        }

        String[] inputS = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            s[i] = Integer.parseInt(inputS[i]);
        }

        int cnt = 0;
        while(!Arrays.equals(card, p)) {
            int temp[] = p.clone();

            for(int i = 0;i < n;i++) {
                p[s[i]] = temp[i];
            }

            if (Arrays.equals(original, p)) {
                cnt = -1;
                break;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
