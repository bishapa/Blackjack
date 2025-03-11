public class Card
{
    private Suit suits;
    private CardType value;


    public Suit getSuits()
    {
        return this.suits;
    }

    public CardType getValue()
    {
        return this.value;
    }

    public Card(Suit suits, CardType value)
    {
        this.suits = suits;
        this.value = value;
    }


}
