package bin;

import java.time.LocalDate;

public class Juice extends Drinks{
    public Juice(String name, double cost, LocalDate date) {
        super(name, cost, date, 2);
    }

    public Juice(String name) {
        super(name);
    }

    public Juice() {
    }
}
