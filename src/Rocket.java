public class Rocket implements SpaceShip{
    String name;
    int carried;

    public Rocket(int cargoCarried){
        carried = cargoCarried;
    }
    @Override
    public boolean launch(String cargoName, int cargoCarried, int perChanceExplosion, int cargoLimit) {
        return true;
    }

    @Override
    public boolean land(String cargoName, int cargoCarried, int perChanceCrash, int cargoLimit) {
        return true;
    }

    @Override
    public boolean canCarry(Item item, int maxLoad, int currentWeight) {
        int itemWeight = item.getWeight();
        if(currentWeight + itemWeight <= maxLoad){
            return true;
        }
        return  false;
    }

    @Override
    public int carry(Item item, int currentWeight) {
        int itemWeight = item.getWeight();
        return itemWeight + currentWeight;
    }
}
