package thisis.implementation;

import java.util.Scanner;

//시각
public class Time {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int cnt = 0;

        for (int h=0; h<=n; h++) {
            for (int m=0; m<60; m++) {
                for (int s=0; s<60; s++) {
                    if (validation(h, m, s)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean validation(int hh, int mm, int ss) {

        return (String.valueOf(hh) + mm + ss).contains("3");
    }
}
