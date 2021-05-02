package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 컴퓨터 조립
 */
public class boj3691 {

    static class Product implements Comparable<Product> {
        String type;
        long price;
        long quality;

        public Product(String type, long price, long quality) {
            this.type = type;
            this.price = price;
            this.quality = quality;
        }

        @Override
        public int compareTo(Product o) {
            return Long.compare(this.quality, o.quality);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            Map<String, Queue<long[]>> products = new HashMap<>();
            for (int i=0; i<n; i++) {
                String[] infos = br.readLine().split(" ");
                long price = Integer.parseInt(infos[2]);
                long quality = Integer.parseInt(infos[3]);

                if (!products.containsKey(infos[0])){
                    products.put(infos[0], new PriorityQueue<>(
                            (a, c) -> { return Long.compare(a[0], c[0]); }
                    )); // 가격순으로
                }
                products.get(infos[0]).add(new long[]{price, quality});
            }

            Queue<Product> q = new PriorityQueue<>();
            long totalPrice = 0; // 현재까지의 가격
            for (String type : products.keySet()) {
                long[] product = products.get(type).poll();
                q.add(new Product(type, product[0], product[1]));
                totalPrice += product[0]; // 부품 총 가격
            }

            while (true) {
                Product part = q.poll();

                boolean find = false;
                long quality = 0, price = 0;
                while (true) {
                    if (products.get(part.type).isEmpty()) {
                        break;
                    }
                    long[] parts = products.get(part.type).poll();
                    price = parts[0];
                    quality = parts[1];
                    if (quality <= part.quality) {
                        continue;
                    }
                    if (totalPrice - part.price + price > b) {
                        break;
                    }
                    find = true;
                    break;
                }

                if (find) {
                    totalPrice = totalPrice - part.price + price;
                    q.add(new Product(part.type, price, quality));
                } else {
                    System.out.println(part.quality);
                    return;
                }
            }

        }
    }
}