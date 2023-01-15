public class Bird implements EggLayable {
    private Flyable flyable = new ImpFly();
    private ImpEggLay eggLayable = new ImpEggLay();

    @Override
    public void eggLay() {
        eggLayable.eggLay();
    }

    public void fly() {
        flyable.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.eggLay();
    }
}
