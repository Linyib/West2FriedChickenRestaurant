package bin;

import java.time.LocalDate;
//测试饮料类和过期函数
public class test {
    public static void main(String[] args) {
        Drinks d=new Beer("beer1",12.9, LocalDate.of(2020,10,1), 49);
        if(d.isOverdue()){
            System.out.println("过期了");
        }
        System.out.println(d.toString());
       var meal=new SetMeal("套餐一",15, "碎皮鸡", d);
        System.out.println(meal.toString());
    }
}
