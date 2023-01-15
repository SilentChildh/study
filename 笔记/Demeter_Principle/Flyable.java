public interface Flyable {
    void fly();
}
class ImpFly implements Flyable {

    @Override
    public void fly() {
        System.out.println("fly");
    }
}