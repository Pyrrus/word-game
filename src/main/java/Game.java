import java.util.Random;
import java.io.Console;

public class Game {
  private String[] words = {"dog", "cat", "hat", "home", "sesquipedalian"};

  private String hideWord;

  private String word;

  private boolean game;

  private int counter;

  public Game() {
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(5);
    word = words[randomInt];
    counter = 1;
    game = true;
    this.hide();
  }

  public void testGame() {
      word = words[0];
      this.hide();
  }

  public boolean update(String guess) {
    for (int i = 0; i < word.length(); i++) {
      char letter = word.charAt(i);
      for (int j = 0; j < guess.length(); j++) {
        if (letter == guess.charAt(j)) {
          char[] setUp = hideWord.toCharArray();
          setUp[i] = guess.charAt(j);
          hideWord = String.valueOf(setUp);
        }
      }
    }

    if (counter == word.length()) {
      game = false;
    }
    if (hideWord.indexOf("_") == -1) {
      game = false;
    }

    counter += 1;

    return game;

  }

  public void hide() {
    String str = "";
    for (int i = 0; i < word.length(); i++) {
      str += "_";
    }
    hideWord = word.replaceAll(word, str);
  }

  public String getWord() {
    return word;
  }

  public String getHide() {
    return hideWord;
  }
}
