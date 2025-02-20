import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardCollection {
    private Map<String, List<Card>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(Card card) {
        cardMap.computeIfAbsent(card.getSymbol(), k -> new ArrayList<>()).add(card);
    }

    public Collection<Card> findCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, new ArrayList<>());
    }

    public static void main(String[] args) {
        CardCollection collection = new CardCollection();
        collection.addCard(new Card("Hearts"));
        collection.addCard(new Card("Diamonds"));
        collection.addCard(new Card("Hearts"));

        Collection<Card> heartsCards = collection.findCardsBySymbol("Hearts");
        System.out.println("Cards with symbol Hearts: " + heartsCards.size());
    }
}