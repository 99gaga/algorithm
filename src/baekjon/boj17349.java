package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1루수가 누구야
 */
public class boj17349 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<int[]> inputs = new ArrayList<>();
        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inputs.add(new int[]{a, b});
        }

        Set<Integer> yes = new HashSet<>();
        Set<Integer> no = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i=0; i<9; i++) { // 하나씩 거짓이라는 것을 가정
            int[] input = inputs.get(i);

            input[0] = input[0] == 0 ? 1 : 0;

            for (int[] in : inputs) {
                if (in[0] == 0) {
                    no.add(in[1]);
                } else {
                    yes.add(in[1]);
                }
            }

            if (yes.size() == 1) {
                for (int k=1; k<=9; k++) {
                    if (yes.contains(k)) {
                        if (no.contains(k)) {
                            break;
                        }
                        result.add(k);
                        break;
                    }
                }
            }

            if (yes.size() == 0 && no.size() <= 8) {
                for (int k=1; k<=9; k++) {
                    if (!no.contains(k)) {
                        result.add(k);
                    }
                }
            }

            input[0] = input[0] == 0 ? 1 : 0;
            yes.clear();
            no.clear();
        }

        if (result.size() == 1) {
            for (int k=1; k<=9; k++) {
                if (result.contains(k)) System.out.println(k);
            }
        } else {
            System.out.println(-1);
        }

    }

}
