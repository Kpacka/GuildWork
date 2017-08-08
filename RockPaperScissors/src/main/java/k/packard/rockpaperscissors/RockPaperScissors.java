/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.packard.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class RockPaperScissors {

    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors");
        boolean playAgain = true;
        int userGameLength, userWins, computerWins, ties;
        String userAnswer, userTry;
        do {
            userWins = 0;
            computerWins = 0;
            ties = 0;
        
            userGameLength = getUserTries();
            //Check for valid input, print error and quit if not valid
            if (userGameLength <= 0 || userGameLength > 10) {
                System.out.println("ERROR: You did not enter a valid number");
                return;
            }

            do {
                
                boolean correctInput = true;
                
                do {

                    userAnswer = getUserAnswer();
                    switch (userAnswer) {
                        case "rock":
                            correctInput = true;
                            break;
                        case "scissors":
                            correctInput = true;
                            break;
                        case "paper":
                            correctInput = true;
                            break;

                        default:
                            System.out.println("You did not enter a correct input");
                            correctInput = false;
                            break;
                    }
                } while (!correctInput);
                      
                int randomInt = getRandomOfThree();
                /*
                    RULES FOR COMPUTER:
                    1 = ROCK
                    2 = PAPER
                    3 = SCISSORS
                 */

                if ((userAnswer.equals("rock") && randomInt == 1)
                        || (userAnswer.equals("paper") && randomInt == 2)
                        || (userAnswer.equals("scissors") && randomInt == 3)) {

                    System.out.println("Tie");
                    ties++;

                } 
                else if (userAnswer.equals("rock") && randomInt == 2) {
                    System.out.println("Paper beats Rock: Computer wins...");
                    computerWins++;
                } 
                else if (userAnswer.equals("rock") && randomInt == 3) {
                    System.out.println("Rock beats Scissors: User wins...");
                    userWins++;
                } 
                else if (userAnswer.equals("paper") && randomInt == 1) {
                    System.out.println("Paper beats Rock: User wins...");
                    userWins++;
                } 
                else if (userAnswer.equals("paper") && randomInt == 3) {
                    System.out.println("Scissors beats Paper: Computer wins...");
                    computerWins++;
                } 
                else if (userAnswer.equals("scissors") && randomInt == 1) {
                    System.out.println("Rock beats Scissors: Computer wins...");
                    computerWins++;
                } 
                else if (userAnswer.equals("scissors") && randomInt == 2) {
                    System.out.println("Scissors beats Paper: User wins...");
                    userWins++;
                } 
                else {
                    System.out.println("An Error Occured");
                    return;
                }

                userGameLength = userGameLength - 1;
                
                //printing empty line for terminal formatting
                System.out.println();

            } 
            while (userGameLength > 0);
          
            System.out.println("Ties: " + ties);
            System.out.println("User Wins: " + userWins);
            System.out.println("Computer Wins: " + computerWins);

            if (userWins > computerWins) {
                System.out.printf("***\n\nCongratulations User, you beat the computer!\n\n***\n");
            } 
            else if (userWins < computerWins) {
                System.out.printf("***\n\nUh Oh..... User, you lost to the computer!\n\n***\n");
            }
            else {
                System.out.println("Tie... No winner declared!");
            }
           
            userTry = getTryAgain();
            char tryChar = userTry.charAt(0);
            if (tryChar == 'y') {
                playAgain = true;                
            }
            else if (tryChar == 'n') {
                playAgain = false;
            }
            else {
                playAgain = false;
            }
        }
        while (playAgain);

    }
    
    

    public static int getUserTries() {
        System.out.print("How many times do you want to play? (1 - 10): ");
        String answerStr = sc.nextLine();

        //Verify the user input is numerical and not null
        char[] answerChar = answerStr.toCharArray();
        if (answerChar.length == 0){
            return -1;
        }
        else {
            for (int i = 0; i < answerChar.length; i++){
                if (Character.isDigit(answerChar[i]) == false) {
                    return -1;
                }
            }
        }       
        return Integer.parseInt(answerStr);
    }

    public static int getRandomOfThree() {
        return ran.nextInt(3) + 1;
    }

    public static String getUserAnswer() {
        System.out.print("rock, paper, or scissors?: ");
        return sc.nextLine();
    }
    
    public static String getTryAgain() {
        boolean compatible = false;
        String userTry;
        do {
            System.out.print("Try Again? (y or n): ");
            userTry = sc.nextLine();
            if (userTry.equals("yes") || userTry.equals("y") || userTry.equals("no") || userTry.equals("n")) {
                compatible = true;
            }
            else {
                compatible = false;
            }
        }
        while (!compatible);
       
        return  userTry;
        
    }

}
