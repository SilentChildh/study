public interface EggLayable {
    void eggLay();
}
class ImpEggLay implements EggLayable {

    @Override
    public void eggLay() {
        System.out.println("lay egg");
    }
}