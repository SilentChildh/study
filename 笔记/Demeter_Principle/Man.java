public class Man implements MakeCoffee{
    CoffeeMechine coffeeMechine = new CoffeeMechine();
    @Override
    public void make() {
        coffeeMechine.make();
    }

}

class TestMakeCoffee {
    public static void main(String[] args) {
        new Man().make();
    }
}