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
      userInput = userInput.toLowerCase();
      if (userInput.contains("you") || userInput.contains("i") || userInput.contains("me") ||
      userInput.contains("am")|| userInput.contains("my") || userInput.contains("your")) { //checks if there are any of the keywords in the user's response.
        // changes words: 
        String[] splitInput = userInput.split("\\s+"); // splits the response into an string array
      
        StringBuilder response = new StringBuilder(""); // intial bot response
        for (int a = 0; a < (splitInput.length) ; a++) { // will go through each word in the phrase.
          if (splitInput[a].equals("i")) { //replaces I with you
          splitInput[a] = "you";
          response.append(splitInput[a]);
          }
          else if (splitInput[a].equals("me")) { //replaces me with you
            splitInput[i] = "you";
            response.append(splitInput[a]); //adds word into bot response
          }
          else if (splitInput[a].equals("am")) { // replaces am with are
            splitInput[a] = "are";
            response.append(splitInput[a]);
          }
          else if (splitInput[a].equals("you")) { // replaces you with I
            splitInput[a] = "I";
            response.append(splitInput[a]);
          }
          else if (splitInput[a].equals("my")) { //replaces my with your
            splitInput[a] = "your";
            response.append(splitInput[a]);
          }
          else if (splitInput[a].equals("your")) { //replaces your with my
            splitInput[a] = "my";
            response.append(splitInput[a]);
          }
          else {
            response.append(splitInput[a]);
          }  
        }
        
        String sent = response.toString().substring(0,1).toUpperCase() + response.toString().substring(1);
        
        if (sent.contains(".")){
          String newSent = sent.replace(".","?");
          System.out.println(newSent);
        }
        else {
          System.out.println(sent);
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
