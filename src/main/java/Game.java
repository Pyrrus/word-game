import java.util.Random;
import java.io.Console;

public class Game {
  private String[] words = {"dog", "cat", "hat", "home", "sesquipedalian", "java", "ruby", "r", "waffles", "nyarlathotep", "blue","time", "kiet", "adam"};

  private String[] hints = {"bijon fraise all the way", "maine coone's are the coolest", "over your head", "where the heart is", "a poet who loves to use big words in his poetry", "programming language", "programming language", "programming language", "goes well with chicken", "just give up, seriously, it's the black pharaoh","you're my boy!","we have so little of it.", "the person you love most in the world", "Kiet's hero"};

  private String hideWord;

  private String word;

  private String hint;

  private boolean game;

  private int counter;

  public Game() {
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(words.length);
    word = words[randomInt];
    hint = hints[randomInt];
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

  public String getHint() {
    return hint;
  }

  public String getHide() {
    return hideWord;
  }
}
