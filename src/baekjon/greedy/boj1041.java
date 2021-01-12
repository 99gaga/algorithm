package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//주사위
public class boj1041 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];
        for (int i=0; i<6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long result = getMinNumber(n, dice);
        System.out.println(result);
    }

    private static long getMinNumber(long n, int[] dice) {
        long oneSide = 51, twoSide = 101, threeSide;

        if (n == 1) {
            Arrays.sort(dice);
            return Arrays.stream(dice).sum() - dice[5];
        }

        for (int i=0; i<dice.length; i++) {
            if (dice[i] < oneSide) {
                oneSide = dice[i];
            }

            for (int j=0; j<dice.length; j++) {
                if (i == 5 - j || j == i) continue;

                int twoComb = dice[i] + dice[j];
                if (twoComb < twoSide) {
                    twoSide = twoComb;
                }
            }
        }

        threeSide = Math.min(dice[0], dice[5]) + Math.min(dice[1], dice[4]) + Math.min(dice[2], dice[3]);

        return (threeSide*4) + (twoSide*(4 + 8*(n-2))) + (oneSide*(n-2)*(5*n-6));
    }
}
