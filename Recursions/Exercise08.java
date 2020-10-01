package Recursions;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class Exercise08 {
    public static boolean isPalindrome(@NotNull String s) {
        if(s.charAt(0) != s.charAt(s.length() - 1))
            return false;
        if(s.length() > 2) {
            s = new String(s.getBytes(), 1, s.length() - 2);
            return isPalindrome(s);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();
        while(!s.isEmpty()) {
            System.out.println(isPalindrome(s) ? "YES" : "NO");
            s = console.nextLine();
        }
    }
}