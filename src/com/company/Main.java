package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        Random random = new Random();
        String userName = "Simple player";


        do {
            System.out.println("Enter Your name");
            userName = scanner.next();

            int myNum = random.nextInt(100) + 1;
            System.out.printf("Cheat: %d\n", myNum);
            boolean userLost = true;


            for (int i = 0; i < 10; i++) {

                String msg = String.format("Try #%d. Guess my number.", (i + 1));
                int userNum = askNumber(msg, 1, 100);

                System.out.printf("You entered %d\n", userNum);
                String greaterMSG = "My number is greater than yours";
                String lessMSG = "My number is less than yours";

                if (myNum > userNum) {
                    System.out.println(greaterMSG);
                } else if (myNum < userNum) {
                    System.out.println(lessMSG);
                } else {
                    userLost = false;
                    System.out.println("You win!");

                    break;
                }

            }


            if (userLost) {
                System.out.println("You lost, " + userName);
            }
            System.out.println("Do you want to repeat?");

        }
        while (scanner.next().equalsIgnoreCase("yes"));
        System.out.printf("Good bye, %s!", userName);

    }


    public static int askNumber(String message, int min, int max) {


        while (true) {
            try {
                System.out.println(message + ":");
                int answer = scanner.nextInt();

                if (answer < min) {
                    System.out.printf("Number should not be less than %d\n", min);
                } else if (answer > max) {
                    System.out.printf("Number should not be greater than %d\n", max);
                } else {
                    return answer;
                }
            } catch (InputMismatchException exception) {
                String str = scanner.next();
                System.out.println("You entered:" + str + " You should enter a number");

            } 

        }
    }

}
