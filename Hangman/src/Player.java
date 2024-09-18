import java.util.ArrayList;
import java.util.List;

public class Player {
    private int lives = 10;
    char[] guesses = {'_','_','_','_','_'};
    List<Character> incorrectGuesses = new ArrayList<>();

    public String call()
    {
        return "[%s %s %s %s %s]".formatted(guesses[0],guesses[1],guesses[2],guesses[3],guesses[4]);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
