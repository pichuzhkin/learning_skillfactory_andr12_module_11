import java.util.Map;
import java.util.TreeMap;

public class House {
    private final int numEntrances, numStoreys, numAptsPerStoreyPerEntrance, maxAptIndex;

    private final TreeMap<Integer, Apartment> apartments = new TreeMap<>();

    public House(int numEntrances, int numStoreys, int numAptsPerStoreyPerEntrance) {
        this.numEntrances = numEntrances;
        this.numStoreys = numStoreys;
        this.numAptsPerStoreyPerEntrance = numAptsPerStoreyPerEntrance;
        this.maxAptIndex = numAptsPerStoreyPerEntrance * numEntrances * numStoreys;
    }


    public void populate(Integer aptNum, Apartment apt) {

        if (aptNum < 1 || aptNum > maxAptIndex) {
            throw new IndexOutOfBoundsException("Invalid apartment number");
        }
        if (this.apartments.get(aptNum) != null) {
            throw new IllegalArgumentException("This apartment is already populated");
        }
        this.apartments.put(aptNum, apt);
    }

    public void populate(Integer aptNum, String singleResidentName) {
        this.populate(aptNum, new Apartment(singleResidentName));
    }

    public void populateFurther(Integer aptNum, String who) {
        Apartment apt = apartments.get(aptNum);
        if (apt == null) {
            throw new IllegalArgumentException("This apartment is not yet populated");
        }
        apt.addResident(who);

    }

    public void reserve(Integer aptNum) {
        this.populate(aptNum, new Apartment());
    }

    public Apartment getLowerNeighbors(Integer toWhichApt) {
        int seqNumInEntrance = toWhichApt % (numStoreys * numAptsPerStoreyPerEntrance);
        return (seqNumInEntrance <= numAptsPerStoreyPerEntrance)
                ? null
                : apartments.get(toWhichApt - numAptsPerStoreyPerEntrance);
    }

    public Apartment getUpperNeighbors(Integer toWhichApt) {
        int seqNumInEntrance = toWhichApt % (numStoreys * numAptsPerStoreyPerEntrance);
        return (seqNumInEntrance >= ((numStoreys - 1) * numAptsPerStoreyPerEntrance))
                ? null
                : apartments.get(toWhichApt + numAptsPerStoreyPerEntrance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("House consists of ").append(this.numStoreys).append(" storeys, ").append(this.numEntrances).append(" entrances, and hosts ").append(numAptsPerStoreyPerEntrance).append(" apartments per entrance per storey").append(System.lineSeparator());
        sb.append("Total capacity is ").append(this.maxAptIndex).append(" apartments").append(System.lineSeparator()).append(System.lineSeparator());
        sb.append("Current residents: ").append(System.lineSeparator()).append(System.lineSeparator());
        for (Map.Entry<Integer, Apartment> apt : apartments.entrySet()) {
            int aptNum = apt.getKey();
            Apartment aptItself = apt.getValue();
            sb.append("Apartment ").append(aptNum).append(": ").append(aptItself).append(System.lineSeparator()).append("above: ").append(getUpperNeighbors(aptNum)).append(System.lineSeparator()).append("below: ").append(getLowerNeighbors(aptNum)).append(System.lineSeparator()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
