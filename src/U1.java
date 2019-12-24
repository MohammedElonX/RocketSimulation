public class U1 extends Rocket {
    private int cargoCarried;
    private int cargoLimit;

    U1(){
        super(0);
    }

    @Override
    public boolean launch(String cargoName, int cargoCarried, int perChanceExplosion, int cargoLimit) {

        double chanceExplosion = (double) perChanceExplosion / 10;

        double launchExplodeChances = (chanceExplosion * cargoCarried) / cargoLimit;
        double randomEvent = Math.random();

        System.out.println("Launching cargo: " + cargoName);
        System.out.println("Random event: " + randomEvent);
        System.out.println("Launch explosion chances: " + launchExplodeChances);

        if (randomEvent <= launchExplodeChances) {
            System.out.println("Cargo " + cargoName + " exploded on launching! -- Relaunching --");
            System.out.println("");
            return false;
        } else {
            System.out.println("Cargo " + cargoName + " Successfully launched");
            System.out.println("");
            return true;
        }
    }

    @Override
    public boolean land(String cargoName, int cargoCarried, int perChanceCrash, int cargoLimit) {

        double chanceCrash = (double) perChanceCrash / 10;

        double landCrashChances = (chanceCrash * cargoCarried) / cargoLimit;
        double randomEvent = Math.random();

        System.out.println("Landing cargo: " + cargoName);
        System.out.println("Random Event: " + randomEvent);
        System.out.println("Land crash chances: " + landCrashChances);

        if (randomEvent <= landCrashChances) {
            System.out.println("Cargo " + cargoName + " crashed on landing! -- Relaunching --");
            System.out.println("");
            return false;
        } else {
            System.out.println("Cargo " + cargoName + " successfully landed");
            System.out.println("");
            return true;
        }
    }
}
