import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private ArrayList<Card> cards = new ArrayList<Card>();


    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public Deck()
    {
        for (var suit : Suit.values())
        {
            for (var cardType : CardType.values())
            {
                cards.add(new Card(suit, cardType));
            }
        }
    }


    public Card drawRandom()
    {
        Random rand = new Random();
        int r = rand.nextInt(cards.size());

        Card currentCard = cards.get(r);
        cards.remove(r);

        return currentCard;
    }


}


