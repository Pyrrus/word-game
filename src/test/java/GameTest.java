import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {
  @Test
  public void runGame_instantiatesCorrectly() {
    Game testGame = new Game();
     assertEquals(true, testGame instanceof Game);
  }

  @Test
  public void runGame_returnWord() {
    Game testGame = new Game();
    String word =  testGame.getWord();
    assertEquals(true, word instanceof String);
  }

  @Test
  public void runGame_returnHide() {
    Game testGame = new Game();
    String word =  testGame.getHide();
    assertEquals(true, word instanceof String);
  }

  @Test
  public void runGame_updateAndPlayWholeWord() {
    Game testGame = new Game();
    testGame.testGame();
    boolean in = true;
    while (in) {
      in = testGame.update("dog");
    }
    assertEquals("dog", testGame.getHide());
  }

  @Test
  public void runGame_updateAndPlayletter_1() {
    Game testGame = new Game();
    testGame.testGame();
    boolean in = true;

    in = testGame.update("d");

    assertEquals("d__", testGame.getHide());
  }

  @Test
  public void runGame_updateAndPlayletter_2() {
    Game testGame = new Game();
    testGame.testGame();
    boolean in = true;

    in = testGame.update("o");

    assertEquals("_o_", testGame.getHide());
  }

  @Test
  public void runGame_updateAndPlayletters_1() {
    Game testGame = new Game();
    testGame.testGame();
    boolean in = true;

    in = testGame.update("og");

    assertEquals("_og", testGame.getHide());
  }
}
