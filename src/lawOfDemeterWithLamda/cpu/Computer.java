package lawOfDemeterWithLamda.cpu;

import java.util.List;

public class Computer {

    // ~Instance Fields
    //--------------------------------------------------------------------------------------

    private Processor processor;
    private List<GraphicsCard> graphicsCards;

    // ~Consturctor
    //--------------------------------------------------------------------------------------

    public Computer(Processor processor, List<GraphicsCard> graphicsCards) {
        this.processor = processor;
        this.graphicsCards = graphicsCards;
    }

    // ~Getter & Setter
    //--------------------------------------------------------------------------------------

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public List<GraphicsCard> getGraphicsCards() {
        return graphicsCards;
    }

    public void setGraphicsCards(List<GraphicsCard> graphicsCards) {
        this.graphicsCards = graphicsCards;
    }
}
