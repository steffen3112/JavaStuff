package lambdas.simpleStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimpleLambda {

    public static void main(String[] args) throws Exception {

        // ~Setup
        //---------------------------------------------------------------------------------
        List<String> dealerCards = Arrays.asList("Heart 8", "Pik 9");

        List<String> playerCards = Arrays.asList("Heart 8", "Clubs 7", "Pik 1");
        List<String> playerCards2 = Arrays.asList("Pik 9", "Heart 8", "Pik 1");
        List<String> playerCards3 = Arrays.asList("Pik 9", "Clubs 7", "Pik 1");
        List<String> playerCards4 = Arrays.asList("Heart 9", "Heart 7", "Pik 1");

        Player myPlayer = new Player("San Holo", playerCards);
        Player myPlayer2 = new Player("Fiirtz", playerCards2);
        Player myPlayer3 = new Player("MR Poker", playerCards3);
        Player myPlayer4 = new Player("Carlson", playerCards4);
        Player2 myPlayer5 = new Player2("Charlie", playerCards);

        List<Player> playerList = new ArrayList<>();
        playerList.add(myPlayer);
        playerList.add(myPlayer2);
        playerList.add(myPlayer3);
        playerList.add(myPlayer4);
        playerList.add(myPlayer5);


        // ~Lambda -> Returns the Players whose cards match any card of the dealer
        //---------------------------------------------------------------------------------

        Predicate<Player> getMatchingPlayer = player -> player.getCards().stream()
                                                                         .anyMatch(dealerCards::contains);

        List<Player> playerFilterd =  playerList.stream()
                                                .filter(getMatchingPlayer)
                                                .collect(Collectors.toList());

        if(playerFilterd.size() != 3) {
            throw new Exception("Failed, actual size: " + playerFilterd.size());
        }

        playerFilterd.forEach(System.out::println);

    }


    // ~ inner Class
    //-------------------------------------------------------------------------------------
    public static class Player {
        String name;
        List<String> cards;

        public Player(String name, List<String> cards) {
            this.name = name;
            this.cards = cards;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getCards() {
            return cards;
        }

        public void setCards(List<String> cards) {
            this.cards = cards;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Player2 extends Player {

        public Player2(String name, List<String> cards) {
            super(name, cards);
        }
    }
}
