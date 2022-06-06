
/*
Multiplication Division game class - game to practice your multiplication and division

user types in p to play game
user types in q to quit
user types in a to add math problem
during the game, they put in problems they need to practice, and will use catch to make sure the user doesnt try to divide by zero. we will use hashmaps to create the study list, and use switch statements for the play and quit of the game.

variables:
Hashmap variable for the math problems
int score for # gotten right

methods:
test method which makes them play their problems they entered
add problem method to add a problem when they want to add one when they type a
and constructor to initialize the hashmap

classes: hashmap class, the main class (MultandDivis), the scanner class to get their input

Author - Sanjana & Tiffany

Change history:
5/13: Created
*/

import java.util.HashMap;

public class Game {
  // Private instance variables to store the facts and score
  private HashMap<String, Integer> facts;
  private int score;

  // Constructor, to initialize the instance variable
  public Game() {
    facts = new HashMap<String, Integer>();
  }

  // Method to let a user create/modify/delete facts
  public void play () {
    System.out.println ("Welcome to the Multiplication and Division Game, where you enter either a multiplication or division problem");
    
    System.out.println ("\nLet's record some problems");
    inputProblem();

    System.out.println ("\nNow let's see if you can solve them");
    answerProblem();
  }

  public void inputProblem() {
    System.out.println ("You can: \n a-view all problems, \n s-set a problem, \n d-delete a problem,\n q-quit recording problems,\n anything else-a problem you want to view");
    while (true) {
      String command = Utils.inputStr("What do you want to do? ");
      switch (command) {
          
        case "a":   // View all facts
          if (facts.size() == 0) {
            System.out.println ("No problems have been set yet.");
          }
          for (String factKey : facts.keySet())
            System.out.println (factKey + ": " + facts.get(factKey));
          break;
          
        case "s":    // Set a fact
          System.out.println ("Math problems have two parts; the equation (must be in either x*y for multiplication or x/y for division) and the answer (an integer of the answer for either x*y or x/y)");

          String equation = Utils.inputStr("What is the equation? ");
      Equation e = new Equation();
      while (!e.parse(equation)) {
        System.out.println ("Please enter a valid equation");
        e = new Equation();
      }
        
      int answer = Utils.inputNum("What is the answer? ");
      if(e.operation.equals("*")){
        if((e.op1 * e.op2) == answer){
          System.out.println("Valid answer");
          facts.put (equation, answer);
        }
        else{
          System.out.println("Wrong answer, try again");
        }
      }
      else if(e.operation.equals("/")){
        if((e.op1/e.op2) == answer){
          System.out.println("Valid answer");
          facts.put (equation, answer);
        }
        else{
          System.out.println("Wrong answer, try again");
        }
      }

          
          /*
          int equation = Utils.inputNum ("What is the equation? ");
          int answer = Utils.inputNum ("What is the answer? ");
          if (equation/100 == 1){
            int n1 = equation%10;
            int n2 = (equation/10)%10;
            if (n1*n2 == answer){
              System.out.println("Valid answer");
              facts.put (equation, answer);
            }
            else{
              System.out.println("Answer is incorrect, please re-enter");
              break;
            }
          }
          if(equation/100 == 2){
            int n3 = equation%10;
            int n4 = (equation/10)%10;
            if (n4/n3 == answer){
              System.out.println("Valid answer");
              facts.put (equation, answer);
            }
            else{
              System.out.println("Answer is incorrect, please re-enter");
              break;
            }
          }
          break;
          */
          
        case "d":    // Delete a equation
          String thing = Utils.inputStr ("What equation do you want to delete? "); // same issue
          facts.remove (thing);
          break;
          
        case "q":    // Quit
          System.out.println ("Done recording facts");
          return;
          
        default:     // Look up a specific fact (the "command")
          System.out.print ("Equation  " + command + ": ");
          System.out.println (facts.get(command));
      }
    }
  }

  public void answerProblem() {
    score = 0;
    for (String factKey : facts.keySet()) {
      int answer = Utils.inputNum ("What's the value of '" + factKey + "''? ");
      if (answer == (facts.get(factKey))) {
        System.out.println ("Correct!");
        score++;
      }
      else {
        System.out.println ("Nope - the answer is: " + facts.get(factKey));
      }
    }
    System.out.println ("Thanks for playing, you scored " + score);
  }
}