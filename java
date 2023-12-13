/*Pseudocode
Step 1
Assign constants and variables
CONSTANT 123;
CONSTANT 456;

variable 123;
variable 456;

Step 2 
Ask for user input
print("Enter 3 dices..");
int userinput; //save input for randomizing
check for invalid inputs
if(dice 1-3 are string){
print("invalid input");
}

Step 3 
Randomize numbers
userinput randomized;

Step 4
Calculate the numbers
random nrs + random nrs = ?

Step 5 
Print results
print("you won/lose the game with " + random nr);
*/
//Calling the class scanner to scan input from the user.
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
//Step 1 - assigning constants and variables
  double WINNER = 12;
  double LOSER = 13;
  double NEITHER = 11;
//Declaring the scanner that will scan user input.  
  Scanner userInput = new Scanner(System.in);
  boolean isGameOver = false; // Controls when to exit while loop
  int number = 0;
  int wins = 0;
  int loss = 0;
  int sum = 0;
    
//keep track of the value of the dice
  int dice1Value = 0;
  int dice2Value = 0;
  int dice3Value = 0;
    
//keep track of which dice is rolled
  boolean isDice1Rolled = false;
  boolean isDice2Rolled = false;
  boolean isDice3Rolled = false;
    
//keep track of how many rolls
    int noOfRolls = 0;
// Random rand = new Random();
// int randomNumber = rand.nextInt(7);

//Using the useDelimiter method which works well with the scanner and will seperate tokens //from input data, could add more such as , or !.
    userInput.useDelimiter("[-:>|\\s]");  
    //Asking for user to enter 1-3 to toss the dices, then reading it as dice1-3 and saving it as int.      

//Step 2 - ask for user input 
System.out.println(" Welcome to dice game 12. You must roll 1-3 dice and try to get the sum of 12 ...");
while(!isGameOver){
  System.out.print("Enter which dice you want to roll [1, 2, 3] (exit with q): ");
//catching invalid inputs by checking if the number entered is below 1 or above 3:
  if(userInput.hasNextInt()){
    number = userInput.nextInt();
    if(number < 1 || number > 3){
      System.out.println("Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q");
      continue;
    }
  }
  else if(userInput.hasNext()){
    String inString = userInput.next();
//Q and q
//when pressing q the game exits
    if(inString.equalsIgnoreCase("q")){
      System.out.println("I am exitinig.");
      isGameOver = true;
      break;
    }
    //in case an other string input then q is entered
    else{
          System.out.println("Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q");
    }
    }
//number = 1, 2 or 3
//if the player press the dice 1 it gets a random nr and a println stating info about //the game, and so on for dice 2 and 3 as well. 
  if(number == 1 && noOfRolls < 3){
    if(!isDice1Rolled){
      isDice1Rolled = true;
      noOfRolls++;
      dice1Value = (int)(Math.random() * 6) + 1; //random nr
      //sum = sum + dice1Value;
      sum += dice1Value;
     System.out.println(dice1Value + " " + dice2Value + " " + dice3Value + " sum: " + sum + " #win: " + wins + " #loss: " + loss);
    }
    else {
      System.out.println("Sorry, you have already rolled that dice. Try again.");
    }
  }
    else if(number == 2 && noOfRolls < 3){
    if(!isDice2Rolled){
      isDice2Rolled = true;
      noOfRolls++;
      dice2Value = (int)(Math.random() * 6) + 1; //random nr
      sum += dice2Value;
      System.out.println(dice1Value + " " + dice2Value + " " + dice3Value + " sum: " + sum + " #win: " + wins + " #loss: " + loss);
    }
    else {
      System.out.println("Sorry, you have already rolled that dice. Try again.");
    }
    }
    else if(number == 3 && noOfRolls < 3){
    if(!isDice3Rolled){
      isDice3Rolled = true;
      noOfRolls++;
      dice3Value = (int)(Math.random() * 6) + 1; //random nr
      sum += dice3Value;
      System.out.println(dice1Value + " " + dice2Value + " " + dice3Value + " sum: " + sum + " #win: " + wins + " #loss: " + loss);
    } 
    else {
      System.out.println("Sorry, you have already rolled that dice. Try again.");
    }
    }
//resetting input  
  number = 0;
//letting the player know if they won or lost by calculating the values of the dices.
  if(noOfRolls == 3){
     if((dice1Value + dice2Value + dice3Value) == WINNER){
        System.out.println("\nYou won!");
        wins++;
      }
      if((dice1Value + dice2Value + dice3Value) >= LOSER){
        System.out.println("\nYou lost!");
        loss++;
      }
        if((dice1Value + dice2Value + dice3Value) <= NEITHER){
        System.out.println("\nYou neither won nor lost the game!");
      }
//resetting the dice's after each round;
    isDice1Rolled = false;
    isDice2Rolled = false;
    isDice3Rolled = false;
//resetting the values after each round:
    sum = 0;
    noOfRolls = 0;
    dice1Value = 0;
    dice2Value = 0;
    dice3Value = 0;
   System.out.println("\nNext round!");
  }
  }
 userInput.close();
}
}
