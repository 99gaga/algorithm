package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 생성
 */
public class boj6137 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Character> S = new ArrayList<>();
        for (int i=0; i<n; i++) {
            S.add(br.readLine().charAt(0));
        }

        int cnt = 0;
        int length = S.size();
        StringBuilder T = new StringBuilder();
        while (cnt < length) {

            int size = S.size();

            if (size == 1) {
                T.append(S.remove(0));
                break;
            }

            char front = S.get(0);
            char back = S.get(size - 1);

            if (front < back) {
                T.append(S.remove(0));
            } else if (back < front) {
                T.append(S.remove(size - 1));
            } else {

                if (size < 4) {
                    T.append(S.remove(0));

                } else {
                    int frontIdx = 1;
                    int backIdx = size - 2;

                    boolean flag = true; // 모두 같은지?
                    while (frontIdx < size/2) {
                        char f = S.get(frontIdx++);
                        char b = S.get(backIdx--);

                        if (f < b) {
                            T.append(S.remove(0));
                            flag = false;
                            break;
                        } else if (b < f) {
                            T.append(S.remove(size - 1));
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        T.append(S.remove(0));
                    }
                }
            }

            cnt++;
            if (cnt % 80 == 0) T.append("\n");
        }

        System.out.println(T.toString());

    }

}
