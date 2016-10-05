/**
* This is the Farmers Game
*
*
*/

import java.util.Scanner;

public class FarmerGame{

  public static boolean cabb;
  public static boolean man;
  public static boolean wolf;
  public static boolean sheep;

  public static void main(String[] args){
    /**
    * This method runs the main program
    * While loop runs while the end method returns 4 (the user has neither won nor lost)
    * Ends the loop and has cases for if the user won or lost
    * @param args This is the command line argument
    * @return This method does not return anything
    */
    init();
    while(end(cabb, sheep, wolf, man) == 4){
      displayGameStatus();
      game();
    } if (end(cabb, sheep, wolf, man) == 1){
      displayGameStatus();
      System.out.println("The sheep ate the cabbage! You lose");
    } if (end(cabb, sheep, wolf, man) == 2){
      displayGameStatus();
      System.out.println("The wolf ate the sheep! You lose");
    } if (end(cabb, sheep, wolf, man) == 3){
      displayGameStatus();
      System.out.println("Good work! You win!");
    }

    }



  public static void init(){
    /**
    * This method give the user instructions and displays a message at the start of the game
    * @param This method takes no parameters
    * @return This method does not return anything
    */
    System.out.print("Welcome to the Farmer's game. Right now there is a ");
    System.out.println("cabbage, goose, wolf and human on one side of a river.");
    System.out.println("Your goal, as the human, is to use a boat move all 4 objects including yourself.");
    System.out.println("However, there are 2 restrictions:");
    System.out.println("1: If you leave the goat and cabbage on the same side alone, the goat will eat the cabbage");
    System.out.println("2: If you leave the wolf and goat on the same side alone, the wolf will eat the goat");
  }

  public static void displayGameStatus(){
    /**
    * Method displays the banks and the river
    *@param No parameters
    *@return does not return anything
    */
    String bank0 = "";
    String bank1 = "";
    if(!cabb){
      bank0 += "  C  ";
    }
    else{
      bank1 += "  C  ";
    }
    if(!sheep){
      bank0 += "  S  ";
    }
    else{
      bank1 += "  S  ";
    }
    if(!wolf){
      bank0 += "  W  ";
    }
    else{
      bank1 += "  W  ";
    }
    if(!man){
      bank0 += "  H  ";
    }
    else{
      bank1 += "  H  ";
    }

    System.out.println(bank0);
    System.out.println("---------------------");
    System.out.println("\n \n \n");
    System.out.println("---------------------");
    System.out.println(bank1);
  }

  public static void game(){
    /**
    * Method that contains actual game
    * Asks for user input on what object to move, validates that is a possible move, then
    * flips the value from false to true or true to false (changing what bank they are on)
    * @param no parameters
    * @return does not return anything
    */
    Scanner s = new Scanner(System.in);
    System.out.println("What would you like to move over?");
    String input = s.nextLine();
    if (input.equalsIgnoreCase("c") && cabb == man){
      cabb = !cabb;
      man = !man;
    } else if (input.equalsIgnoreCase("s") && sheep == man){
      sheep = !sheep;
      man = !man;
    } else if (input.equalsIgnoreCase("h")){
      man = !man;
    } else if (input.equalsIgnoreCase("w") && wolf == man){
      wolf = !wolf;
      man = !man;
    } else{
      System.out.println("That is not a valid input");
    }

  }
  public static int end(boolean c, boolean s,boolean w, boolean h){
    /**
    * Method takes in position of cabbage, sheep, wolf, and human
    * Returns 1,2,3 or 4 depending, each one corresponding to a different ending
    * @param c boolean value of cabbage
    * @param s boolean value of sheep
    * @param w boolean value of wolf
    * @param h boolean value of human
    * @return int Value that corresponds to specific ending
    */
    if ((c == s) && (c != w && c != h)){
        return 1;
    } else if ((w == s) && (w != h && w != c)){
        return 2;
    } else if (w && c && s && h){
        return 3;
    } else{
      return 4;
    }
  }

}
