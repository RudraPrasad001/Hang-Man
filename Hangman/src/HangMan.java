import java.util.*;

public class HangMan {
    int k=1;
    int actualLives;
    boolean win=false;
    boolean YesOrNo;
    Player player;
    String[] wordList = {"STAFF", "FRESH", "PILOT", "COVER", "CROSS", "NURSE", "SHOWN", "LEAST", "LABEL", "BRING", "CHAIR", "SHIRT", "TRUCK", "LUNCH", "NOISE", "SWEET", "DEPTH", "CHILD", "SIXTH", "OFTEN", "BROKE", "ALTER", "BENCH", "FORTH", "OFTEN", "THROW", "LOOSE", "GROSS", "SCOPE", "VITAL", "FORUM", "CRIME", "URBAN", "CABLE", "TRAIN", "STAGE", "FIRST", "ISSUE", "ANGRY", "MONEY", "MAKER", "ALLOW", "GROUP", "MODEL", "TRUST", "THING", "CATCH", "TRUTH", "MEANT", "DRIVE", "CLOCK", "TERRY", "FAULT", "PROVE", "AMONG", "TEACH", "MEDIA", "EQUAL", "TREND", "CHECK", "SHIFT", "MOUTH", "MINOR", "TRUTH", "LIVES", "ROMAN", "VOICE", "TRAIN", "MIXED", "SEVEN", "GROUP", "FLUID", "LARGE", "LEVEL", "TABLE", "TITLE", "TITLE", "DOZEN", "GRANT", "SMILE", "LEGAL", "MONTH", "REACH", "PHOTO", "EXIST", "MORAL", "CABLE", "NEEDS",
            "BENCH", "TIMES", "RURAL", "TREND", "COVER", "MAKER", "QUICK", "NORTH", "METAL", "LOOSE", "TITLE", "STORM", "KOMII"};
    String word;
    List<Character> boy = new ArrayList<>();
    char[] ha;
    Scanner s = new Scanner(System.in);

    public HangMan(Player player)
    {
        this.player = player;
        Random r = new Random();
        word = wordList[r.nextInt(0,100)];
        ha = word.toCharArray();

        for(char c:ha)
        {
            boy.add(c);
        }

    }
    public void startGame()
    {
        System.out.println("\t\tHANG MAN\nGuess the five letter word!!");
        while(player.getLives()>0)
        {
            System.out.println(player.call() + "\t\tIncorrect guesses"+player.incorrectGuesses
            +"\tRemaining lives = "+player.getLives()+"\n\n Enter your guess in a letter!!");

            String guess = s.nextLine();
            if(guess.length()>1)
            {
                setGuess(guess);
            }
            else{
            char truGuess = guess.toUpperCase().charAt(0);
                setGuess(truGuess);}

        }
        if(win)
        {
            System.out.println("YOU WIN!! THE WORD WAS "+word+ "    Remaining lives = "+actualLives);
        }
        else
        {
            System.out.println("All lives lost!! You lose!!\t\t The word was "+word);
        }
    }

    public void setGuess(String s)
    {
        if(s.equalsIgnoreCase(word))
        {
            actualLives=player.getLives();
            player.setLives(0);
            win = true;

        }
        else
        {
            s =s.toUpperCase();
            char[] ca = s.toCharArray();

            for(int i =0;i<word.length();i++)
            {
                if(ca[i]==boy.get(i))
                {
                    setGuess(ca[i]);
                }
                else if (boy.contains(ca[i]))
                {
                    if(k==1)
                    {
                        player.setLives(player.getLives() - 1);
                        k+=1;
                    }
                }
                else {
                    player.setLives(player.getLives() - 1);
                }
            }
        }
    }

    public void setGuess(char c)
    {
        YesOrNo = false;
        for(int i =0;i< boy.size();i++)
        {
            if(boy.get(i)==c)
            {
                player.guesses[i]=c;
                YesOrNo =true;
                if(Arrays.equals(player.guesses, ha))
                {
                    System.out.println(Arrays.toString(player.guesses));
                    actualLives=player.getLives();
                    player.setLives(0);
                    win=true;
                }
            }

        }
        if(!YesOrNo) {

            if(!player.incorrectGuesses.contains(c))
            {
                player.incorrectGuesses.add(c);
                player.setLives(player.getLives() - 1);
            }
            YesOrNo =false;
        }
    }
}
