package lawOfDemeterWithLamda;

import lawOfDemeterWithLamda.cpu.Computer;
import lawOfDemeterWithLamda.cpu.GraphicsCard;
import lawOfDemeterWithLamda.cpu.Processor;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Client {


    // ~Main
    //-----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        // -> Nullpointer
        //List<GraphicsCard> graphicsCard = getGraphicsCard(null);

        Optional<List<String>> optionalGraphicsCard = safeResolve(
                () -> createComputer().getGraphicsCards().stream()
                                                            .map(GraphicsCard::getDriver)
                                                            .peek(System.out::println)
                                                            .collect(Collectors.toList()));

        optionalGraphicsCard.ifPresent(System.out::println);

    }


    // ~"old school"
    //-----------------------------------------------------------------------------------------------------------------

    static List<String> getGraphicsCardDrivers(Computer computer) {
        List<String> driverList = new ArrayList<>();
        if(computer != null) {
            List<GraphicsCard> graphicsCards = computer.getGraphicsCards();

            if(graphicsCards != null) {
                for(GraphicsCard graphicsCard : graphicsCards) {
                    String driver = graphicsCard.getDriver();
                    if(driver != null) {
                        driverList.add(driver);
                        return driverList;
                    }
                }
            }
        }
        return Collections.singletonList("UNKNOWN");
    }

    // ~"JDK 8 style V1"
    //-----------------------------------------------------------------------------------------------------------------

    static <T> Optional<T> safeResolve(final Supplier<T> resolver) {
        try {
            final T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch(final NullPointerException npe) {
            return Optional.empty();
        }

    }

    // ~Setup
    //-----------------------------------------------------------------------------------------------------------------


    private static Computer createComputer() {

        Processor intel = new Processor("Intel", false);
        List<GraphicsCard> graphicsCards = new ArrayList<>();
        graphicsCards.add(new GraphicsCard("HAX 4", "standard i5", new Processor("AMD", true)));
        graphicsCards.add(new GraphicsCard("HAX 4", "standard i5", new Processor("AMD", true)));
        graphicsCards.add(new GraphicsCard("HAX 4", "standard i5", new Processor("AMD", true)));
        graphicsCards.add(new GraphicsCard("HAX 4", "standard i5", new Processor("AMD", true)));

        return new Computer(intel, graphicsCards);
    }

}
