package bin;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate date;
    protected int shelfLife;

    public Drinks() {
    }

    public Drinks(String name, double cost, LocalDate date, int shelfLife) {
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.shelfLife = shelfLife;
    }

    public Drinks(String name) {
        this.name = name;
    }

    public boolean isOverdue(){
        LocalDate now=LocalDate.now();
        long day=0;
        try {
            day = now.toEpochDay() - this.date.toEpochDay();
            if(day>shelfLife) return true;
        }catch (NullPointerException e){
            System.out.println(day);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drinks drinks = (Drinks) o;
        return Objects.equals(name, drinks.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", shelfLife=" + shelfLife +
                '}';
    }
}
