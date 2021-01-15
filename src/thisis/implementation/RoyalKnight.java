package thisis.implementation;

import java.util.Scanner;

//왕실의 나이트
public class RoyalKnight {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int row = input.charAt(1) - '0';
        int col = input.charAt(0) - 'a' + 1;

        int[][] move = {
            {-2, -1}, {-2, 1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        int cnt = 0;

        for (int i=0; i<move.length; i++) {
            int tempX = row + move[i][0];
            int tempY = col + move[i][1];

            if (tempX >= 1 && tempX <= 8 && tempY >= 1 && tempY <= 8) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
