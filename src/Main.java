import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        House h = new House(2, 3, 3);
        h.populate(1, "Just Marusya");
        h.populate(4, "Veteran Woman");
        h.reserve(3);
        h.populate(6,"Cat owner");
        h.populateFurther(4, "Man");
        h.populateFurther(4, "Woman");
        h.populateFurther(4, "Child");
        h.populate(7, new Apartment(new ArrayList<>(Arrays.asList("Mechanic", "Mechanic's wife", "Mechanic's younger daughter", "Mechanic's senior daughter"))));
        h.populate(12, "Street cleaner man");
        h.populateFurther(12,"Street cleaners wife");
        h.populate(15,"Foreign country resident");

        System.out.println(h.getUpperNeighbors(12));
        System.out.println(h.getLowerNeighbors(6));
        System.out.println();
        System.out.println(h);
    }
}
