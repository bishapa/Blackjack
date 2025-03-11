import java.util.Scanner;

public class BlackJack
{
    private int playerOneScore;
    private int playerTwoScore;

    private boolean isAceOne = false;
    private boolean isAceTwo = false;

    private boolean isStickOne = false;
    private boolean isStickTwo = false;
    private boolean turn = false;
    private Deck deck = new Deck();

    Scanner scanner = new Scanner(System.in);

    public boolean makeTurn()
    {
        System.out.println("Player " + (!turn ? 1 : 2) + ": Twist or Stick? (" + (!turn ? playerOneScore : playerTwoScore) + ")");
        String choice = scanner.nextLine();

        if (choice.equals("twist"))
        {
            if (!turn)
            {
                drawPlayer(false);
                if (playerOneScore > 21)
                {
                    System.out.println("Player 2 has won!");
                    return true;
                }
            } else
            {
                drawPlayer(true);
                if (playerTwoScore > 21)
                {
                    System.out.println("Player 1 has won!");
                    return true;
                }
            }
        }
        else
        {
            if (!turn)
            {
                isStickOne = true;
            }
            else
            {
                isStickTwo = true;
            }
        }
        if (!turn && !isStickTwo)
        {
            turn = !turn;
        }
        else if (turn && !isStickOne)
        {
            turn = !turn;
        }
        return false;
    }

    public void play()
    {
        drawPlayer(false);

        drawPlayer(true);

        while (true)
        {
            if (isStickOne && isStickTwo)
            {
                if (playerOneScore == playerTwoScore)
                {
                    System.out.println("Draw");
                } else if (playerOneScore > playerTwoScore)
                {
                    System.out.println("Player One Wins!");
                } else
                {
                    System.out.println("Player Two Wins!");
                }
                return;
            }
            if (makeTurn())
            {
                return;
            }
        }
    }

    public void drawPlayer(boolean player)
    {
        Card card = deck.drawRandom();
        System.out.println("Your card is: " + card.getValue() + " of " + card.getSuits());

        int score = card.getValue().getValue();
        if (score > 10 && score < 14)
        {
            score = 10;
        }

        if (score == 14)
        {
            score = 11;
        }

        if (!player)
        {
            playerOneScore += score;
            if (score == 11)
            {
                isAceOne = true;
            }
            if (playerOneScore > 21 && isAceOne)
            {
                score -= 10;
                if (score != 11)
                {
                    isAceOne = false;
                }
            }
            System.out.println("Player 1 score is: " + playerOneScore);
        } else
        {
            playerTwoScore += score;
            if (score == 11)
            {
                isAceTwo = true;
            }
            if (playerTwoScore > 21 && isAceTwo)
            {
                score -= 10;
                if (score != 11)
                {
                    isAceTwo = false;
                }
            }
            System.out.println("Player 2 score is: " + playerTwoScore);
        }
    }
}
