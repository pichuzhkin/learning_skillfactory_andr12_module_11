import java.util.ArrayList;

public class Apartment {

    private ArrayList<String> residents = new ArrayList<>();

    public Apartment()
    {

    }
    public Apartment(ArrayList<String> residents) {
        this.residents = residents;
    }

    public Apartment(String singleResident) {
        this.residents.add(singleResident);
    }

    public void addResident(String residentName)
    {
        this.residents.add(residentName);
    }

    @Override
    public String toString()
    {
        return this.residents.size() == 0 ? "nobody" : this.residents.toString();
    }
}

