// Joshua Millonado
// November 12, 2022
// COMP182L ID: 16324

// Lab Project #3: GUessingGame

import TreePackage.*;
import java.util.Scanner;

class GuessingGame
{

   public static void main(String[] args)
   {
      String response;
      DecisionTree<String> gameTree = new DecisionTree<>("Is it in North America?","Brazil","United States");
      
      do {
         System.out.println("Think of a country and I will guess it.");
         gameTree = play(gameTree);
         System.out.print("Play Again?");
         response = getUserResponse();
      } while (response.toLowerCase().equals("yes"));
      System.out.println("Bye!");
   } // end of main
   
   public static String getUserResponse()
   {
      //TODO
      //Scanner response = new Scanner(System.in);
      //response = response.nextline();
      Scanner input = new Scanner(System.in);
      String response  = input.nextLine();
      return response;
   } // end of getUserResponse
   
   public static boolean isUserResponseYes()
   {
      String answer = getUserResponse();
      if (answer.toLowerCase().equals("yes")) {
         return true;
      } else {
         return false;
      }
   } // isUserResponseYes
   
   public static DecisionTree<String> play(DecisionTree<String> gameTree)
   {
      // TODO initialize current node to root
      gameTree.resetCurrentNode();
      // TODO while loop answer has not been reached
      while (!gameTree.isAnswer())
      {
         //Ask current question
         System.out.println(gameTree.getCurrentData());
         if (isUserResponseYes()) {
            gameTree.advanceToYes();
         } else {
            //TODO
            gameTree.advanceToNo();
         }
      } // end while
      //TODO assertion: leaf is reached
      assert gameTree.isAnswer(): "Leaf reached";
      // Make Guess
      System.out.println("My guess is " + gameTree.getCurrentData() + ". Am I right?");
      // TODO if user responds 'yes'
      if(isUserResponseYes())
      {
         System.out.println("I win.");
      } else {
         learn(gameTree);
        // return gameTree;
      }  
      return gameTree;
   } // end play
   
   // Responds to the user when this program makes wrong guess and 
   // extends he decision trree so that this guess is not made again.
   public static void learn(DecisionTree<String> gameTree)
   {
      System.out.println("I give up; what are you thinking of?");
      
      //TODO set correct answer to string
      String correctAnswer = getUserResponse();
      //TODO set current answer to string
      String currentAnswer = gameTree.getCurrentData();
      
      System.out.println("Give me a question whose answer is yes for " + correctAnswer + " but no for " + currentAnswer);
      String newQuestion = getUserResponse();
      
      //TODO create a nwe question with current data
      gameTree.setCurrentData(newQuestion);
      //TODO set response based on current answer and correct answer
      gameTree.setResponses(currentAnswer,correctAnswer);
   }// end learn
}// end of program