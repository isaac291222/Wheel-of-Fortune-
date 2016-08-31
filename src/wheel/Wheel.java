
package wheel;


//Nathan Grant 109816757

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Wheel {

    private static ArrayList values;
    // Scanner inputFile;

    private static ArrayList<String> phrases = new ArrayList<>();

    public static void readFile(String fileName) {
        Scanner inputFile;

        try {
            inputFile = new Scanner(new File(fileName));
            values = new ArrayList();
            while (inputFile.hasNext()) {
                values.add(inputFile.nextLine());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public static void readFilePhrase(String fileName) {

        Scanner inputFile;
        try {
            inputFile = new Scanner(new File(fileName));
            phrases = new ArrayList();
            while (inputFile.hasNext()) {
                phrases.add(inputFile.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private static String secret2 = null;
    private static String secret = null;
    private static int score1 = 0, score2 = 0;
    private static boolean userTurn = true;
    private static boolean computerTurn = true;
    private static ArrayList<String> userG = new ArrayList();
    private static ArrayList<String> computerG = new ArrayList();
    private static String guesses = " ";
    private static boolean notDone=true;

    private static int wheelValueIndex = 0;
    private static int wheelValue = 0;
    private static String username;
    private static boolean test=true;
    private static ArrayList<Character>record= new ArrayList();
   private static boolean test1=true;
    
    public static void spin() {
        //int r = (int) (Math.random() * 50+ 1);
        int r = ((int) (Math.random() * 49));
        
         while(r>0){
         wheelValueIndex++;
         r++;
         if(wheelValueIndex>values.size()-1)
         wheelValueIndex=0;
         }
         
        //System.out.print(r);
        if (values.get(wheelValueIndex).equals("Bankruptcy")) {
            //if (r > values.size() - 1)

            wheelValue = -100000;
        } else if (values.get(wheelValueIndex).equals("1Million")) {
            wheelValue = 100000;
        } else 
            wheelValue = Integer.parseInt((String) values.get(wheelValueIndex));
        
            System.out.println((userTurn? username : "Computer")+" spins "+wheelValue);
        
    }

    public static boolean gameOver() {
        for (char c : secret2.toCharArray()) {
            if (!userG.contains("" + c) && !computerG.contains("" + c)) {
                return false;
            }
        }
        return true;
    }

    public static void printState() {
        System.out.println((userTurn ? "user" : "computer") + "turn");

        System.out.println("user score: " + score1);
        System.out.println("computer score: " + score2);
        System.out.println("Guess: ");
        //printGuess();
        System.out.println();
    }
    /*
    public static boolean check(){
        
    }
    */

    public static void printGuess() {

        for (char c : secret2.toCharArray()) {
            if (userG.contains("" + c) || computerG.contains("" + c)) {
                System.out.print(c + " ");
            } else if (c == ' ') {
                System.out.print(" ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    public static boolean correct(char c2) {
        for (char c : secret2.toCharArray()) {
            if (c == c2) {
                return true;
            }
        }
        return false;

    }

    public static void updateUserScore(char c2) {
        int counter=0;
        for (char c : secret2.toCharArray()) {
            if (c == c2) {
                counter++;
            }
                
           //System.out.print(wheelValue+counte+)
                
        }
        score1 += wheelValue*counter;
         if(score1<0){
                    score1=0;
                }
        System.out.println("There are "+counter+" instances in the phrase");
       

    }
    public static void record(char c){
        record.add(c);
    }

    public static void updateComputerScore(char c2) {
          int counter2=0;
        for (char c : secret2.toCharArray()) {
          
            if (c == c2) {
                counter2++;
            }
        }
        score2 += wheelValue*counter2;
        if(score2<0){
            score2=0;
         }
        System.out.println("There is "+counter2+" instances in the phrase");
    }

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        readFile("scores.txt");
        readFilePhrase("phrases.txt");
        secret2 = (phrases.get((int) (Math.random() * phrases.size()))).toLowerCase();
       System.out.println("Whats your name");
       
        username= input.next();
       
        //System.out.println(secret2);
        
        //spin();
         for (char c : secret2.toCharArray()) {
            if (userG.contains("" + c) || computerG.contains("" + c)) {
                System.out.print(c + " ");
            } else if (c == ' ') {
                System.out.print(" ");
            } else {
                System.out.print("_ ");
                notDone=true;
            }
        }
         boolean test1;
        while (gameOver() == false&& notDone) {
             spin();
            //printState();
            if (userTurn && wheelValue <= 0) {
                //spin();
                System.out.println("Skip users turn");
                userTurn = !userTurn;
                score1 += wheelValue;
                if (score1 < 0) {
                    score1 = 0;
                }

            }
            if (userTurn && wheelValue > 0) {
                //spin();
                if (userTurn && wheelValue <= 0) {
                System.out.println("Skip userss turn");
                userTurn = !userTurn;
                /*
                score1 += wheelValue;
                if (score1 < 0) {
                    score1 = 0;
                }*/

            }
                System.out.println("1-Guess letter; 2= Guess phrases");
                //input.nextLine();
                char option = input.next().charAt(0);

                if (option == '1') {
                    System.out.println("Enter your letter");
                    //input.next();
                    char c = input.next().charAt(0);
                    record(c);
                    
                    if (userG.contains(c + "")) {
                        //userTurn = false;
                        //userTurn = !userTurn;
                        System.out.println(c + " has already been guessed");
                        userTurn = !userTurn;
                    } 
                    if(userG.containsAll(record)){
                        System.out.println("This has already been guessed");
                    
                    }
                        else if (!correct(c)) {

                        userTurn = !userTurn;
                        System.out.println("This letter is not in the phrase");
                    } else if(userTurn=userTurn){
                        userG.add(c + "");
                        updateUserScore(c);
                    }
                }
                if(option=='2'){
                   
                    System.out.println("Enter the phrase");
                    input.nextLine();
                    String phrase= input.nextLine();
                   
                    if(phrase.equals(secret2)){
                        System.out.println("Congratulations you are correct.");
                        test1=true;
                        break;
                      
                    }
                    else
                        System.out.println("Sorry you are not correct");
                        userTurn=!userTurn;
                        test1=false;
                }
                
            }/*
            else if (userTurn && wheelValue <= 0) {
                System.out.println("Skip users turn");
                userTurn = !userTurn;
                score1 += wheelValue;
                if (score1 < 0) {
                    score1 = 0;
                }

            } else if (!userTurn && wheelValue <= 0) {
                System.out.print("Skip computer's turn");
                userTurn = !userTurn;
                score2 += wheelValue;
                if (score2 < 0) {
                    score2 = 0;
                }
            }
            */
            //spin();
            while(!userTurn) {
                spin();
                
                 if (!userTurn && wheelValue <= 0) {
                //spin();
                System.out.println("Skip computers turn");
                userTurn = !userTurn;
                score2 += wheelValue;
                if (score2 < 0) {
                    score2 = 0;
                }

            }
                      //spin();
                  if (!userTurn && wheelValue > 0) {
                char c= (char) (Math.random()*('z'-'a')+'a');
                System.out.println("The computer's guess is " + c);
                record(c);
                /*
                if (userG.contains(c + "")) {
                    //userTurn = false;
                    System.out.println("This has already been guessed");

                    userTurn = !userTurn;
                } 
                        */
                if (computerG.contains(c + "")) {
                    //userTurn = false;
                    System.out.println("This has already been guessed");

                    userTurn=true;
                    continue;
                
                } if(computerG.containsAll(record)){
                        System.out.println("This has already been guessed");
                    
                    } else if (!correct(c)) {

                        //userTurn = true;
                        System.out.println("This letter is not in the phrase");
                        userTurn = !userTurn;
                    } else {
                    computerG.add(c + "");
                    updateComputerScore(c);
                }
             printState();

            }
                 /*
               //  spin();
                 if (!userTurn && wheelValue <= 0) {
                System.out.println("Skip computer's turn");
                userTurn = !userTurn;
                score2 += wheelValue;
                if (score2 < 0) {
                    score2 = 0;
                }
            }
                 if (!userTurn && wheelValue <= 0) {
                System.out.println("Skip computer's turn");
                 test=!test;
                 /*
                score2 += wheelValue;
                if (score2 < 0) {
                    score2 = 0;
                
                 
            
                
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                        */
                    /*else if (userTurn && wheelValue <= 0) {
                System.out.println("Skip users turn");
                userTurn = userTurn;
                score1 += wheelValue;
                if (score1 < 0) {
                    score1 = 0;
                }

            } */
            /*
            else if (!userTurn && wheelValue <= 0) {
                System.out.print("Skip computer's turn");
                userTurn = userTurn;
                score2 += wheelValue;
                if (score2 < 0) {
                    score2 = 0;
                }
            }*///printState(); 
                 
            }
             printState();
             
                  notDone=false;
            for (char c : secret2.toCharArray()) {
            if (userG.contains("" + c) || computerG.contains("" + c)) {
                System.out.print(c + "");
            } else if (c == ' ') {
                System.out.print(" ");
            } else {
                System.out.print("_ ");
                notDone=true;
            }
        }
            if(!notDone){
                break;
            }
           
            
        }
        
        System.out.println("Congrats! The game is over");
        if(test1=false){
        if(score1>score2){
            System.out.println(username+" won");
        }
        if(score2>score1){
            System.out.println("computer won");
        }
        if(score2==score1){
            System.out.println("Its a tie");
        }
        }
        
        if(test1=true){
            System.out.println("Congrats you won");
        }
    }
} 