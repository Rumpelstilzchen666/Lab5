package Recursions;

import java.util.Scanner;

public interface Exercise04 {
    static int nNumbersWithSum(int k, int s, boolean first) {
        int n = 0;
        for(int i = (first ? 1 : 0); i <= 9; i++){
            if(s - i == 0)
                return 1 + n;
            if(k > 1)
                n += nNumbersWithSum(k - 1, s - i, false);
        }
        return 0;
    }

    static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int k = console.nextInt(), s = console.nextInt();
        while(k > 0) {
            System.out.println(nNumbersWithSum(k, s, true));
            k = console.nextInt(); s = console.nextInt();
        }
    }
}
