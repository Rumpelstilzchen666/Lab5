package Recursions;

import java.util.Scanner;

public class Exercise04 {
    public static long nNumbersWithSum(long k, long s, boolean first) {
        long n = 0;
        for(long i = (first ? 1 : 0); i <= 9; i++) {
            if(s - i == 0)
                return 1 + n;
            if(k > 1)
                n += nNumbersWithSum(k - 1, s - i, false);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long k = console.nextLong(), s = console.nextLong();
        while(k > 0) {
            System.out.println(nNumbersWithSum(k, s, true));
            k = console.nextLong(); s = console.nextLong();
        }
    }
}
