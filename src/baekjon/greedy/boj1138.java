package baekjon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

//한줄로 서기
public class boj1138 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> result = new ArrayList<>();
        int n = scan.nextInt();
        int[] arr = new int[n+1];

        for (int i=1; i<arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i=arr.length-1; i>0; i--) {
            result.add(arr[i], i);
        }

        result.stream().forEach(x -> System.out.print(x + " "));
    }
}
