import java.util.Scanner;
import java.util.Random;

class Conversation {

  public static void main(String[] arguments) {
    Scanner sc = new Scanner(System.in);
    // You will start the conversation here.
    System.out.println("How many rounds?");
    int rounds = sc.nextInt();
    // greeting of bot
    String greeting = "Hi there!  What's on your mind?";
    sc.nextLine();
    // add greeting to transcript
    System.out.println(greeting);
    String[] transcipt = new String[2*rounds]; // each round has a two new strings added to transcript
    // loops for every user response (rounds)
    for (int i = 0; i < rounds; i++) {
      String userInput = sc.nextLine(); // user's response
      // adds userinput to transcript array based on the index
      if (i == 0) {
        transcipt[i] = userInput; 
      }
      else {
        transcipt[2*i] = userInput;
      }
      
      
      String userInputLower = userInput.toLowerCase(); // lowercases the whole response

      // checks to see if any words need to be mirrored
      if (userInputLower.contains("you") || userInputLower.contains("i") || userInputLower.contains("me") ||
          userInputLower.contains("am") || userInputLower.contains("my") || userInputLower.contains("your")
          || userInputLower.contains("are")) { // checks if there are any of the keywords in the user's response.
        // changes words
        // splits the response into an string array
        String[] word = userInputLower.split("\\s+"); // '\\s+' is for whitespace

        StringBuilder response = new StringBuilder(""); // intial bot response
        for (int a = 0; a < (word.length); a++) { // will go through each word in the phrase.
          if (word[a].equals("i")) { // replaces I with you
            word[a] = "you";
            response.append(word[a] + " ");
          } else if (word[a].equals("me")) { // replaces me with you
            word[a] = "you";
            response.append(word[a] + " "); // adds word into bot response
          } else if (word[a].equals("am")) { // replaces am with are
            word[a] = "are";
            response.append(word[a] + " ");
          } else if (word[a].equals("you")) { // replaces you with I
            word[a] = "I";
            response.append(word[a] + " ");
          } else if (word[a].equals("my")) { // replaces my with your
            word[a] = "your";
            response.append(word[a] + " ");
          } else if (word[a].equals("your")) { // replaces your with my
            word[a] = "my";
            response.append(word[a] + " ");
          } else if (word[a].equals("are")) { // replaces are with am
            word[a] = "am";
            response.append(word[a] + " ");
          } else { // adds word that does not need to be changed
            response.append(word[a] + " ");
          }

        }
        // assembles the words into a sentence
        String sent = response.toString().substring(0, 1).toUpperCase() + response.toString().substring(1);
        System.out.println(sent.replace(".", "?"));
        
        // adds the bot's response to the transcript based on the index
        if (i == 0) {
        transcipt[i+1] = sent.replace(".", "?");
        }
        else {
          transcipt[2*i + 1] = sent.replace(".", "?");
        }
      }
      // responds to input with a random phrase
      else {
        // create array of phrases the bot can respond with
        String[] phrase = { "How interesting...", "Oh?", "Exciting!" };
        // have it respond with a random phrase from the array.
        Random rand = new Random();
        int random_index = rand.nextInt(phrase.length);
        System.out.println(phrase[random_index]);
        // adds bot's response to transcript based on index
        if (i ==0) {
          transcipt[i+1] = phrase[random_index];
        }
        else {
          transcipt[2*i + 1] = phrase[random_index];
        }
      }
    }
    // after rounds, chat says goodbye
    System.out.println("Goodbye!");
    // prints conversation
    System.out.println("TRANSCRIPT:");
    System.out.println(greeting);
    // prints each phrase used in conversation
    for (int i = 0; i < transcipt.length; i++) {
      System.out.println(transcipt[i]);
    }
    System.out.println("Goodbye!");
    sc.close();
  }
}
