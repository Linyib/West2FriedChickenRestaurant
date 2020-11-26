package bin;

import java.time.LocalDate;

public class Beer extends Drinks{
    //酒精度数
    protected float alcoholDegree;

    public Beer(String name, double cost, LocalDate date, float alcoholDegree) {
        super(name, cost, date, 30);
        this.alcoholDegree = alcoholDegree;
    }

    public Beer(String name, float alcoholDegree) {
        super(name);
        this.alcoholDegree = alcoholDegree;
    }

    public Beer() {
    }
}
