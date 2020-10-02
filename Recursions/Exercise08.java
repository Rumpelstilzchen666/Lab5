package Recursions;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Exercise08 {
    private static boolean isPalindromeSB(@NotNull StringBuilder str) {
        if(str.charAt(0) != str.charAt(str.length() - 1))
            return false;
        if(str.length() > 2) {
            return isPalindromeSB(
                    str.deleteCharAt(0).deleteCharAt(str.length() - 1));
        }
        return true;
    }

    public static String isPalindrome(@NotNull String str) {
        if(str.length() == 0)
            return "YES";
        return isPalindromeSB(new StringBuilder(str)) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();
        while(!s.isEmpty()) {
            System.out.println(isPalindrome(s));
            s = console.nextLine();
        }
    }
}