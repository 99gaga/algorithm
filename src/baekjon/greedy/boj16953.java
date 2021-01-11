package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//A -> B
public class boj16953 {

    final static int A = 0;
    final static int B = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] num = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};

        System.out.println(getCnt(num)+1);
    }

    private static int getCnt(int[] num) {
        int cnt = 0;

        while (true) {
            if (num[B] % 10 == 1) {
                num[B] = (num[B]-1)/10;
            } else if (num[B] % 2 == 0) {
                num[B] /= 2;
            } else {
                cnt = -2;
                break;
            }
            cnt++;

            if (num[A] == num[B]) {
                break;
            } else if (num[A] > num[B]) {
                cnt = -2;
                break;
            }
        }

        return cnt;
    }
}
