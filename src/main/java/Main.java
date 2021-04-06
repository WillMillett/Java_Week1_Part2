/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fayt
 */ 

import java.util.Random;
import java.util.Scanner;

public class Main {
   // The max number of guess the user is allowed
    static final short MAX_NUM_OF_GUESSES = 5;
    
    public static void main(String[] args) {
        
        //initialize a new Scanner object for user input
        Scanner scan = new Scanner(System.in);
        // create a new instance of Random class
        Random randNum = new Random();
        //used for wether or not the user's guess is right or wrong
        boolean isGuessRight = false;
        //used for wether the user entered a valid numric number
        boolean isInputGood = false;
        //will store the guess from the user
        String userInput;
        //get a random number between 1 and 100 amd store it in number
        int number = randNum.nextInt(100 + 1);
        //will be used for counting the number of guesses a user has made
        short numberOfGuessedNumbers = 1;
        
        //ask the user to guess a number
        System.out.println("Please guess a number between 1 and 100");
        //store the user inpupt
        userInput = scan.nextLine();
        //for storing the numeric value of the user's guess
        int guessedNumber = 0;
        //keep the user looping and asking for a correct number till one is given
        do {
            
            try{
            
                //try to convert the user input into a int and store the results in guessedNumber
                 guessedNumber = Integer.parseInt(userInput);
                //flag to true
                isInputGood = true;
            }catch(Exception e){
            
                System.out.println("Incorrect input. Please ennter a numeric Number between 1 and 100");
                //store the user inpupt
                 userInput = scan.nextLine();
                //flag to false
                isInputGood = false;
            }
            
        } while (!isInputGood);
        
        
        do {
            
            if (guessedNumber >= number - 10 && guessedNumber <= number + 10) {
                isGuessRight = true;
            }else{
            
                //if we are here the user guessed wrong
                //Let the suer know they guessed wrong
                System.out.println("Your guess was not correct, Please try again");
               
                //ask for a new number
                //ask the user to guess a number
                  System.out.println("Please guess a number between 1 and 100");
                //store the user inpupt
                userInput = scan.nextLine();
                 //keep the user looping and asking for a correct number till one is given
                do {

                    try{

                        //try to convert the user input into a int and store the results in guessedNumber
                        guessedNumber = Integer.parseInt(userInput);
                        //flag to true
                        isInputGood = true;
                    }catch(Exception e){

                        System.out.println("Incorrect input. Please ennter a numeric Number between 1 and 100");
                        //store the user inpupt
                         userInput = scan.nextLine();
                        //flag to false
                        isInputGood = false;
                    }

                } while (!isInputGood);
            }
            //incrememnt the numberOfGuessedNumbers the user has made
            numberOfGuessedNumbers++;
            
        } while (!isGuessRight && numberOfGuessedNumbers != MAX_NUM_OF_GUESSES );
        
        //check if the user guessed the right number
        if(!isGuessRight){
            //let user know they are out of trys
          System.out.println("You are out of guesses. The number was " + number);
        }else{
            //let the user know their guess was good
            System.out.println("Your guess was correct. Congratulations");
        }
    }
}