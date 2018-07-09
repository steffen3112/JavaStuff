package lawOfDemeterWithLamda;

public class GraphicsCard {

    // ~Instance Fields
    //--------------------------------------------------------------------------------------

    private String driver;
    private String firmWare;
    private Processor processor;

    // ~Constructor
    //--------------------------------------------------------------------------------------

    public GraphicsCard(String driver, String firmWare, Processor processor) {
        this.driver = driver;
        this.firmWare = firmWare;
        this.processor = processor;
    }

    // ~Getter & Setter
    //--------------------------------------------------------------------------------------

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getFirmWare() {
        return firmWare;
    }

    public void setFirmWare(String firmWare) {
        this.firmWare = firmWare;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
