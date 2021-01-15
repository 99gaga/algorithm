package thisis.implementation;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

//상하좌우
public class UpDownLeftRight {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[] input = scan.nextLine().split(" ");

        int x = 1, y = 1;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        String[] commands = {"U", "R", "L", "D"};

        for (String command : input) {
            int tempX = 0, tempY = 0;
            for (int i = 0; i<commands.length; i++) {
                if (command.equals(commands[i])) {
                    tempX = x + dx[i];
                    tempY = y + dy[i];
                }
            }

            if (tempX < 1 || tempY < 1 || tempX > n || tempY > n) continue;

            x = tempX;
            y = tempY;
        }

        System.out.println(x + " " + y);
    }
}
