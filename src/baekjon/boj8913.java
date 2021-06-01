package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 뽑기
 */
public class boj8913 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            compression(br.readLine());
            System.out.println(result);
            result = 0;
        }

    }

    private static void compression(String str) {
        if (result == 1) return; // 메모리 초과를 막기 위해 result=1일 경우 탐색 중지

        int len = str.length(); // 문자열 길이
        char duplicatedChar = str.charAt(0); // 비교할 값
        int cnt = 0; // 초기화

        for (int i=0; i<len; i++) {
            char c = str.charAt(i);

            if (duplicatedChar == c) {
                cnt++;
            } else {
                if (cnt >= 2) { // 중복된 값이 2개 이상이라면 중복값 제거 후 재귀 호출
                    compression(str.substring(0, i-cnt) + str.substring(i, len));
                }
                // 초기화
                duplicatedChar = c;
                cnt = 1;
            }
        }

        if (cnt == len && cnt >= 2) { // 길이와 같고 중복된 값이 2개 이상일 경우에만 result를 1로 갱신
            result = 1;
        }

    }

}
