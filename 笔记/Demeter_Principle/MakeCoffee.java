public interface MakeCoffee {
    void make();
}
class CoffeeMechine implements MakeCoffee{

    private void addCoffeeBean() {
        System.out.println("放咖啡豆");
    }
    //加水
    private void addWater() {
        System.out.println("加水");
    }
    //制作咖啡
    private void makeCoffee() {
        System.out.println("制作咖啡");
    }
    @Override
    public void make() {
        addCoffeeBean();
        addWater();
        makeCoffee();
    }
}