package bin;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Scanner;
//模拟西二奶茶店进货和销售环节，异常处理
public class test2 {
    public static void main(String[] args) {
        var orange=new Juice("橙汁", 20, LocalDate.of(2020,11,10));
        var watermelon=new Juice("西瓜汁", 20, LocalDate.of(2020,11,10));
        var budweiser=new Beer("百威", 21, LocalDate.of(2020,11,10),3.1f);
        var corona=new Beer("科罗娜", 22, LocalDate.of(2020,11,10),3.1f);
        var West2=new West2FriedChickenRestaurant(120);
        System.out.println("欢迎来到西二炸鸡店，本店提供以下套餐：");
        West2.ShowMeals();

        West2.Purchase(new Drinks[]{orange,watermelon,budweiser,corona});
        int n=4;
        while (n>0) {
            String s;
            Scanner scanner=new Scanner(System.in);
            s=scanner.nextLine();
            West2.SellMeal(new SetMeal(s));
            n--;
        }
        West2.ShowBalance();
        West2.Purchase(new Drinks[]{orange,watermelon,budweiser,corona,corona,corona,corona});
        West2.ShowBalance();
    }
}
