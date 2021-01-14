package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//회문
public class boj17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int test=0; test<n; test++) {
            char[] str = br.readLine().toCharArray();
            int cnt = 0;

            //검사
            for (int i=0, j=str.length-1; i<=j; i++, j--) {
                if (str[i] == str[j]) continue;

                if (str[i] != str[j-1] && str[i+1] != str[j]) {
                    cnt = 2;
                } else {
                    if (str[i] == str[j-1] && str[i+1] == str[j-2]) {
                        cnt++;
                        j--;
                    } else {
                        cnt++;
                        i++;
                    }
                }

                if (cnt == 2) break;
            }

            System.out.println(cnt);
        }
    }
}