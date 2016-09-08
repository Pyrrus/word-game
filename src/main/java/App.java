import java.io.Console;

public class App {
  public static void main(String[] args) {

    Console console = System.console();
    boolean in = true;

    Game game = new Game();

    while (in) {
      String guess = console.readLine("The guess the word: " + game.getHide() + ": ");
      in = game.update(guess);
    }

    if (game.getWord().equals(game.getHide())) {
      System.out.println("You win the game: " + game.getWord());
    } else {
      System.out.println("You fail the game.\nThe word is " + game.getWord());
    }
  }
}
