public class Bird implements EggLayability{
    private Flyability flyability = new ImpFly();
    private ImpEggLay eggLayability = new ImpEggLay();

    @Override
    public void eggLay() {
        eggLayability.eggLay();
    }

    public void fly() {
        flyability.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.eggLay();
    }
}
