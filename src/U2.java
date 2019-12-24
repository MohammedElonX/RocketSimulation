public class U2 extends Rocket{
    private int cargoCarried;
    private int cargoLimit;

    U2(){
        super(0);
    }
    @Override
    public boolean launch(String cargoName, int cargoCarried, int perChanceExplosion, int cargoLimit) {
        double probability = 0.04 * cargoCarried / cargoLimit;
        if(probability >= 50){
            return true;
        }
        return false;
    }

    @Override
    public boolean land(String cargoName, int cargoCarried, int perChanceCrash, int cargoLimit) {
        double probability = 0.08 * cargoCarried / cargoLimit;
        if(probability >= 50){
            return true;
        }
        return false;
    }
}
