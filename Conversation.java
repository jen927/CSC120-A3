import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    Scanner sc = new Scanner(System.in);
    // You will start the conversation here.
    System.out.println("How many rounds?");
    int rounds = sc.nextInt();
    System.out.println("Hi there!  What's on your mind?"); //greeting of bot
    for (int i = 0; i < rounds; i++) { // loops for every user response (rounds)

      String userInput = sc.nextLine(); // user's response
      
      if (userInput.contains("you") || userInput.contains("I") || userInput.contains("me") ||
      userInput.contains("am")|| userInput.contains("my") || userInput.contains("your")) { //checks if there are any of the keywords in the user's response.
        // changes words: 
        String[] splitInput = userInput.split(" "); // splits the response into an string array
        for (int i = 0; 0 < splitInput.length; i++) { // will go through each word in the phrase.
          String response = ""; // intial bot response
          if (splitInput[i].equals("I")) { //replaces I with you
          splitInput[i] = "you";
          }
          else if (splitInput[i].equals("me")) { //replaces me with you
            splitInput[i] = "you";
          }
          else if (splitInput[i].equals("am")) { // replaces am with are
            splitInput[i] = "are";
          }
          else if (splitInput[i].equals("you")) { // replaces you with I
            splitInput[i] = "I";
          }
          else if (splitInput[i].equals("my")) { //replaces my with your
            splitInput[i] = "your";
          }
          else if (splitInput[i].equals("your")) { //replaces your with my
            splitInput[i] = "my";
          }
        }    
      }
      else {
        // create array of phrases the bot can respond with
        // have it respond with a random phrase from the array.
      }
    }

    sc.close();    
  }
}
