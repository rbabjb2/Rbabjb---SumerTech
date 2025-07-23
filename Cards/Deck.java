import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*import javax.smartcardio.Card; */
public class Deck {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Card> deck;
    ArrayList<Card> plr1Deck = new ArrayList<Card>();
    ArrayList<Card> plr2Deck = new ArrayList<Card>();

    public Deck() {
        startCards();
        deck = scramble(deck);
        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) {
                plr1Deck.add(deck.get(i));
            } else {
                plr2Deck.add(deck.get(i));
            }
        }
        deck.clear();
        while (true) {
            System.out.println("Press enter to draw.");
            scanner.nextLine();
            Card plr1Card = draw(1);
            Card plr2Card = draw(2);
            System.out.println("Player one has: " + plr1Card.getNum() + " , " + plr1Card.getSuit());
            System.out.println("Player two has: " + plr2Card.getNum() + " , " + plr2Card.getSuit());

        }
    }

    public static void main(String[] args) {
        new Deck();
    }

    public static ArrayList<Card> scramble(ArrayList<Card> array) {
        Random random = new Random();
        for (int i = array.size() - 1; i > 0; i--) {
            int currentNumber = random.nextInt(i);
            Card lastNumber = array.get(i);
            array.set(i, array.get(currentNumber));
            array.set(currentNumber, lastNumber);

        }
        return array;
    }

    public void startCards() {
        deck = new ArrayList<Card>(52);
        String suitStr = "";

        for (int suit = 0; suit < 4; suit++) {
            for (int num = 1; num <= 13; num++) {
                switch (suit) {
                    case 0:
                        suitStr = "spades";
                        break;
                    case 1:
                        suitStr = "clubs";
                        break;
                    case 2:
                        suitStr = "hearts";
                    case 3:
                        suitStr = "diamonds";
                        break;
                }

                if (num == 1) {
                    Card card = new Card("ace", suitStr);
                    deck.add((num - 1) + (suit * 13), card);
                } else if (num == 11) {
                    Card card = new Card("jack", suitStr);
                    deck.add((num - 1) + (suit * 13), card);
                } else if (num == 12) {
                    Card card = new Card("queen", suitStr);
                    deck.add((num - 1) + (suit * 13), card);
                } else if (num == 13) {
                    Card card = new Card("king", suitStr);
                    deck.add((num - 1) + (suit * 13), card);
                } else {
                    Card card = new Card(Integer.toString(num), suitStr);
                    deck.add((num - 1) + (suit * 13), card);
                }

            }
        }
    }

    public Card draw(int plr) {
        Card top;
        switch (plr) {
            case 1:
                top = plr1Deck.get(plr1Deck.size() - 1);
                plr1Deck.remove(plr1Deck.size() - 1);
                return top;
            case 2:
                top = plr2Deck.get(plr2Deck.size() - 1);
                plr2Deck.remove(plr2Deck.size() - 1);
                return top;

        }
        return null;
    }
}