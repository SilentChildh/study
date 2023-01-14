public interface EggLayability {
    void eggLay();
}
class ImpEggLay implements EggLayability{

    @Override
    public void eggLay() {
        System.out.println("lay egg");
    }
}