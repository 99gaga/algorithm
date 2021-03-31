package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        int target = v - a;
        int day = a - b;
        int result = target%day==0 ? target/day : target/day+1;

        System.out.println(result + 1);
    }
}
