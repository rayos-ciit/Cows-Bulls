/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject2;

import java.util.Scanner;

/**
 *
 * @author janre
 */
public class Q3_PT2_Rayos_final {

    //strings that are set//
    public static final String rock = "rock";
    public static final String paper = "paper";
    public static final String scissors = "scissors";
    //inputs for both players//
    public static String inputPlayer1 = "";
    public static String inputPlayer2 = "";
    public static String readEnter = "";
    //read//
    public static Scanner scn = new Scanner(System.in);
    //determines players' outcome//
    public static int playersStatus = 0;
    //set up for array//
    public static String set = "";
    public static String guess = "";
    //amount of bulls and cows//
    public static int bullsAmount = 0;
    public static int cowsAmount = 0;
    //important ints for guesser/setter parts//
    public static int digits = 4;
    public static int[] integers = new int[10];
    //ints for the check//
    public static int sInt;
    public static int gInt;
    //attempts for the game//
    public static int attempts = 11;

    //functions//
    static void print(String message) {
        System.out.print(message);
    }

    static void printLn(String message) {
        System.out.println(message);
    }

    static void invalidFunction() {

        printLn("[You have entered an invalid input, please only input what is stated (typed choices are case-sensitive).]\n");

    }

    static void enterToContinue() {

        String readEnter = scn.nextLine();

        while (readEnter != null) {

            System.out.println(readEnter);

            if (readEnter.isEmpty()) {

                return;
            }

            if (scn.hasNextLine()) {

                readEnter = scn.nextLine();

            } else {

                readEnter = null;

            }
        }

    }

    static void playersStatus() {

        switch (playersStatus) {

            case 1:
                printLn("[Player one won! You shall now input the 4-digit number.]\n(Player two will guess!)\n\n");
                break;
            //player one setter, player two guesser outcome//
            case 2:
                printLn("[Player two won! You shall now input the 4-digit number.]\n(Player one will guess!)\n\n");
                break;
            //player two setter, player one guesser outcome//
            default:
                printLn("[Tie! rock-paper-scissors shall continue!]\n\n(or misinput error; refer to error below!)]\n\n");
                break;
            //Tie/no one won, game continues and error catch//
        }

    }

    static void rockPaperGameResult() {

        if (inputPlayer1.equals(rock) && inputPlayer2.equals(scissors)) {
            playersStatus = 1;

        } else if (inputPlayer1.equals(paper) && inputPlayer2.equals(rock)) {
            playersStatus = 1;

        } else if (inputPlayer1.equals(scissors) && inputPlayer2.equals(paper)) {
            playersStatus = 1;
            //player one win results above//

        } else if (inputPlayer2.equals(rock) && inputPlayer1.equals(scissors)) {
            playersStatus = 2;

        } else if (inputPlayer2.equals(paper) && inputPlayer1.equals(rock)) {
            playersStatus = 2;

        } else if (inputPlayer2.equals(scissors) && inputPlayer1.equals(paper)) {
            playersStatus = 2;
            //player two win resuls above//

        } else {
            playersStatus = 3;
        }   //tie and game continues or error occured//

    }

    static void rockPaperScissors() {
        do {

            printLn("[Player 1, what's your input?]");
            inputPlayer1 = scn.nextLine();

            switch (inputPlayer1) {
                case "rock":
                    inputPlayer1 = rock;
                    printLn("");
                    break;
                case "paper":
                    inputPlayer1 = paper;
                    printLn("");
                    break;
                case "scissors":
                    inputPlayer1 = scissors;
                    printLn("");
                    break;
                default:
                    inputPlayer1 = "error";
                    printLn("");
                    invalidFunction();
                    break;
            }

        } while (inputPlayer1.equals("error"));

        do {

            printLn("[Player 2, what's your input?]");
            inputPlayer2 = scn.nextLine();

            switch (inputPlayer2) {
                case "rock":
                    inputPlayer2 = rock;
                    printLn("");
                    break;
                case "paper":
                    inputPlayer2 = paper;
                    printLn("");
                    break;
                case "scissors":
                    inputPlayer2 = scissors;
                    printLn("");
                    break;
                default:
                    inputPlayer1 = "error";
                    invalidFunction();
                    break;
            }

        } while (inputPlayer2.equals("error"));

    }

    static void mainMenu() {

        printLn("Welcome to a game of Cows and Bulls!\n [Press ENTER to continue!]\n");
        enterToContinue();
        print("(setter and guesser roles shall be determined by a rock-paper-scissors game!)\n\n");
        print("The rules are simple! The following game consists of a 'setter' and a 'guesser', the 'setter' will set a 4-digit number\n");
        print("and the 'guesser' would guess the 4 digits with respect to the positions of the setter's 4-digit number.\n");
        print("the 'guesser' has 10 tries and if the guesses a digit in their position correctly, the game will state it as a 'bull'.\n");
        print("And if the 'guesser' has guess wrong the game will state it as a 'cow'.\n");
        printLn("if the 'guesser' gets all the 'bulls' within 10 tries, they will win! And if not, they lose.\n\n");
        printLn("[Press ENTER to START rock-paper-scissors!]");
        enterToContinue();

    }

    static void cowsBullsCheck() {

        for (int i = 0; i < set.length(); i++) {

            sInt = set.charAt(i) - '0';
            gInt = guess.charAt(i) - '0';

            if (sInt == gInt) {
                bullsAmount++;
            } else {
                if (integers[sInt]++ < 0) {
                    cowsAmount++;
                }
                if (integers[gInt]-- > 0) {
                    cowsAmount++;
                }
            }

        }

        printLn("[You have " + bullsAmount + " bulls " + "and " + cowsAmount + " cows!]\n");

    }

    static void setterPart() {

        printLn("[Press ENTER to continue!]\n");
        enterToContinue();
        do {
            printLn("[What will be your 4-digit number, setter?]");
            set = scn.nextLine();

            if (set.length() == digits) {

                sInt = Integer.parseInt(set);

            } else {

                printLn("[Please only input a 4-digit number as stated above.]");
                set = "error";
            }

        } while (set == "error");

    }

    static void guesserPart() {
        do {
            //reset amounts so that values don't stack//
            cowsAmount = 0;
            bullsAmount = 0;
            printLn("[What will be your guess, guesser?]");
            printLn("[YOU HAVE " + attempts + " ATTEMPTS LEFT!]");
            guess = scn.nextLine();

            if (set.length() == digits) {

                gInt = Integer.parseInt(guess);

            } else {

                printLn("[Please only input a 4-digit number as stated above.\n]");
                guess = "error";
            }

        } while (guess == "error");
    }

    static void cowsBullsResult() {

        if (bullsAmount >= 4) {
            printLn("[The guesser won! Wonderful work guesser.]\n [Guessing you were a little too predictable, setter!]");
            System.exit(0);
        } else if (attempts <= 1) {
            printLn("[Setter won! Quite a random number you put there huh?]\n [Gotta read setter better next time, guesser!");
        }
    }

    public static void main(String[] args) {

        //printLn("test to make sure functions aren't messing up main.");
        //start//
        mainMenu(); //tutorial and main menu//
        //rockpaperscissors game start//
        do {

            rockPaperScissors();
            rockPaperGameResult();
            playersStatus();

        } while (playersStatus == 3);
        //rockpaperscissors game end//

        //cowsandbulls game start//
        setterPart();
        do {
            attempts--;
            guesserPart();
            cowsBullsCheck();

            if (bullsAmount >= 4) {
                cowsBullsResult();
            } //guesser win outcome!//

        } while (attempts > 1);

        cowsBullsResult(); //setter win outcome!//

    }   

}

