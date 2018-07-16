package lawOfDemeterWithLamda.cpu;

public class Processor {

    // ~Instance Fields
    //--------------------------------------------------------------------------------------

    private String vendor;
    private boolean overClockable;

    // ~Constructor
    //--------------------------------------------------------------------------------------

    public Processor(String vendor, boolean overClockable) {
        this.vendor = vendor;
        this.overClockable = overClockable;
    }

    // ~Getter & Setter
    //--------------------------------------------------------------------------------------

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public boolean isOverClockable() {
        return overClockable;
    }

    public void setOverClockable(boolean overClockable) {
        this.overClockable = overClockable;
    }
}
