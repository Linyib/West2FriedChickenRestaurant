package bin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    //餐厅账目余额
    private double balance;
    //存储元素比较少，获取速度更快
    //啤酒列表
    private List<Beer> beers=new ArrayList<>();
    //果汁列表
    private List<Juice> juices=new ArrayList<>();
    //套餐列表
    private static List<SetMeal> meals=new ArrayList<>();
    //套餐列表静态初始化
    static {
        meals=List.of(new SetMeal("套餐一",30,"脆皮炸鸡",new Juice("橙汁")),
                new SetMeal("套餐二",30,"脆皮炸鸡",new Juice("西瓜汁")),
                new SetMeal("套餐三",28,"脆皮炸鸡",new Beer("百威", 3.1f)),
                new SetMeal("套餐四",29,"脆皮炸鸡",new Beer("科罗娜", 4.5f)));
    }
    public void ShowBalance(){
        System.out.println("资金余额："+balance);
    }
    public void ShowMeals(){
        for(SetMeal m:meals){
            System.out.print(m.mealName+" 价格:"+m.mealPrice+" "+m.friedChicken+'+'+m.drink.name);
            if(m.drink instanceof Beer) System.out.print("("+((Beer) m.drink).alcoholDegree+"%)");
            System.out.println();
        }
    }

    public West2FriedChickenRestaurant(double balance) {
        this.balance = balance;
    }

    private void use(Beer drink){
        if(beers.contains(drink)){
            System.out.print("出售"+drink.name);
            beers.remove(drink);
        }
    }
    private void use(Juice drink){
        if(juices.contains(drink)){
            System.out.print("出售"+drink.name);
            juices.remove(drink);
        }
    }

    @Override
    //售卖
    public void SellMeal(SetMeal meal) {
        if(meals.contains(meal)){
            for(SetMeal m:meals){
                if(m.equals(meal)){
                    meal=m;
                    break;
                }
            }
            if(!beers.contains(meal.drink)&&!juices.contains(meal.drink)){
                try{
                    throw new IngredientSortOutException();
                }catch (IngredientSortOutException e){
                    System.out.println(meal.drink.name+"卖完了，进货中...");
                }
            }
            else if(meal.drink instanceof Beer){
                Drinks d=new Beer();
                for(Beer b:beers){
                    if(meal.drink.equals(b)) d=b;
                }
                use((Beer) d);
                System.out.println("+"+"脆皮炸鸡，"+"收取"+meal.mealPrice);
                if(d.isOverdue()) System.out.println("饮品以过期，可以选择退货");
                balance+=meal.mealPrice;
            }
            else if(meal.drink instanceof Juice){
                Drinks d=new Juice();
                for(Juice b:juices){
                    if(meal.drink.equals(b)) d=b;
                }
                use((Juice) d);
                System.out.println("+"+"脆皮炸鸡，"+"收取"+meal.mealPrice);
                if(d.isOverdue()) System.out.println("饮品以过期，可以选择退货");
                balance+=meal.mealPrice;
            }
        }
    }

    @Override
    //批量进货
    public void Purchase(Drinks... drink) {
        double costs=0;
        for(Drinks d:drink){
            costs+=d.cost;
        }
        try{
            if(costs>balance) throw new OverdraftBalanceException();
        }catch (OverdraftBalanceException e){
            System.out.println("进货费用超出拥有余额,进货还需资金"+(costs-balance));
        }
        if(costs<=balance){
            System.out.println("正在进货...");
            balance-=costs;
            for(Drinks d:drink){
                if(d instanceof Beer){
                    beers.add((Beer) d);
                }
                else if(d instanceof Juice){
                    juices.add((Juice) d);
                }
            }
        }
    }
}
