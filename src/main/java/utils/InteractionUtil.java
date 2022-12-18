package utils;

import java.util.Scanner;

public class InteractionUtil {

    private final static Scanner sc = new Scanner(System.in);

    public static String getUserInput(String message) {
        System.out.println(message);
        return sc.next();
    }
}
