package Recursions;

import java.util.Scanner;

public interface Exercise01{
    static String TriangularSequence(int t, int n) {
        String str = "";
        for(int i = 0; i < t; i++, n--) {
            if(n == 0)
                return str;
            str += t + ", ";
        }
        return str + TriangularSequence(t + 1, n);
    }

    static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        while(n != 0) {
            System.out.println(TriangularSequence(1, n) + "\b\b");
            n = console.nextInt();
        }
    }
}