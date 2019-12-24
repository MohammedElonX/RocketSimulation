public interface SpaceShip {
    boolean launch(String cargoName, int cargoCarried, int perChanceExplosion, int cargoLimit);
    boolean land(String cargoName, int cargoCarried, int perChanceCrash, int cargoLimit);
    boolean canCarry(Item item, int maxLoad, int currentWeight);
    int carry(Item item, int currentWeight);

}
