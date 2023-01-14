public interface Flyability {
    void fly();
}
class ImpFly implements Flyability{

    @Override
    public void fly() {
        System.out.println("fly");
    }
}