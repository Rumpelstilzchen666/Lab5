package Recursions;

import java.util.Scanner;

public class Exercise04 {
    public static long nNumbersWithSum(long k, long s, boolean firstZero) {
        long n = 0;
        if(k > 0)
            for(long i = (firstZero ? 0 : 1); i <= 9; i++) {
                if(s - i == 0)
                    return 1 + n;
                n += nNumbersWithSum(k - 1, s - i, true);
            }
        return 0;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long k = console.nextLong(), s = console.nextLong();
        while(k > 0) {
            System.out.println(nNumbersWithSum(k, s, false));
            k = console.nextLong(); s = console.nextLong();
        }
    }
}