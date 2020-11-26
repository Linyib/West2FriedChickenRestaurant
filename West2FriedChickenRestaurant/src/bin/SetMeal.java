package bin;

import java.time.Period;
import java.util.Objects;

public class SetMeal {
    protected String mealName;
    protected double mealPrice;
    protected String friedChicken;
    protected Drinks drink;

    public SetMeal(String mealName, double mealPrice, String friedChicken, Drinks drink) {
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.friedChicken = friedChicken;
        this.drink = drink;
    }

    public SetMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "SetMeal{" +
                "mealName='" + mealName + '\'' +
                ", mealPrice=" + mealPrice +
                ", friedChicken='" + friedChicken + '\'' +
                ", drink=" + drink +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetMeal setMeal = (SetMeal) o;
        return Objects.equals(mealName, setMeal.mealName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealName);
    }
}
