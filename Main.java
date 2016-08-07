# priyaka
import java.util.Scanner;

    public class Main{
        private static Scanner x;

        public static void main(String[] args) {
            Scanner x = new Scanner(System.in);
            int num = x.nextInt();
            for (int t = 1; t <= num; t++) {
                int m = x.nextInt();
                int n = x.nextInt();

                if (m >= 1 && n <= 1000000000 && n - m <= 100000) {
                    for (int current = m; current <= n; current++) {
                        int sqr_root = (int) Math.sqrt(current);
                        boolean is_prime = true;
                        for (int i = 2; i <= sqr_root; i++) {
                            if (current % i == 0) {
                                is_prime = false;
                            }
                        }
                        if (is_prime) {
                            System.out.println(current);
                        }
                    }
                }
            }
        }
    }
