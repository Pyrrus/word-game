import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

  public static void main(String[] args) {

    Console console = System.console();
    boolean in = true;
    String output = "";
    String output2 = "";

    // The name of the file to open.
    String fileName = "timmay.rtf";

    String fileName2 = "failWhale.rtf";

    output = readFile(fileName);

    output2 = readFile(fileName2);

    Game game = new Game();

    while (in) {
      String guess = console.readLine("Guess the word: " + game.getHide() + ": ");
      in = game.update(guess);
    }

    if (game.getWord().equals(game.getHide())) {
      System.out.println("You win the game: " + game.getWord());
      System.out.println(output);
    } else {
      System.out.println(output2);
      System.out.println("You fail the game.\nThe word is " + game.getWord());
    }
  }

  public static String readFile (String fileName) {
    String output = "";

    // This will reference one line at a time
    String line = null;

    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader =
      new FileReader(fileName);

      // Always wrap FileReader in BufferedReader.
      BufferedReader bufferedReader =
      new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null) {
        output += line + "\n";
      }

      // Always close files.
      bufferedReader.close();
    }
    catch(FileNotFoundException ex) {
      System.out.println(
      "Unable to open file '" +
      fileName + "'");
    }
    catch(IOException ex) {
      System.out.println(
      "Error reading file '"
      + fileName + "'");
      // Or we could just do this:
      // ex.printStackTrace();
    }

    return output;
  }
}
