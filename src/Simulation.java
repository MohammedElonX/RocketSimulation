import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import static java.lang.Integer.parseInt;

public class Simulation{
    List<Integer> fleetCosts = new ArrayList<Integer>();

    public List loadItems(String phase) throws FileNotFoundException {
        FileInputStream rocketPhase = new FileInputStream(phase);
        BufferedReader itemList = new BufferedReader(new InputStreamReader(rocketPhase));
        List<Item> items = new ArrayList<>();

        try{
            while (true){
                String line = itemList.readLine();
                if(line == null){
                    break;
                }
            }
            String line = itemList.readLine();
            String[] split = line.split("=");
            String itemName = split[0];
            int itemWeight = parseInt(split[1]);
            Item item = new Item(itemName, itemWeight);

            items.add(item);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                itemList.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    Rocket rocket = new Rocket(0);

    public ArrayList<Rocket> load(String phase, int weight, int maxWeight) throws FileNotFoundException {
        ArrayList<Rocket> rocketFleet = new ArrayList<>();
        List<Item> itemsToLoad = loadItems(phase);

        ListIterator<Item> item = itemsToLoad.listIterator();

        int currentWeight = 0;
        int maxLoad = maxWeight - weight;

        while(item.hasNext()){
            Item itemObject = item.next();

            if(rocket.canCarry(itemObject, maxLoad, currentWeight)){
                currentWeight = rocket.carry(itemObject, currentWeight);
                item.remove();
            }else {
                String rocketName = UUID.randomUUID().toString().substring(0,6);
                Rocket rocket = new Rocket(0);

                rocket.name = "rocket-" + rocketName;
                rocket.carried = currentWeight;
                rocketFleet.add(rocket);
                item.remove();

                currentWeight = itemObject.getWeight();
            }
        }
        System.out.println("--" + rocketFleet.size() + "Rocket ready for launch.");
        System.out.println("");
        return rocketFleet;
    }

    public int runSimulation(ArrayList<Rocket> fleet, int maxLoad, int rocketCost,
                             int perChanceExplosion, int perChanceCrash){
        int currentFleetCost = 0;
        for (Rocket R : fleet) {
            U1 unit = new U1();
            while (!unit.launch(R.name, R.carried, perChanceExplosion, maxLoad) ||
                    ! unit.land(R.name, R.carried, perChanceCrash, maxLoad)) {

                currentFleetCost = currentFleetCost + rocketCost;
                System.out.println("-- Current simulation cost: $" + currentFleetCost);
                System.out.println("");
            }
            currentFleetCost = currentFleetCost + rocketCost;
            System.out.println("-- Current simulation cost: $" + currentFleetCost);
            System.out.println("");
        }
        //ArrayList fleetCosts = new ArrayList<>();
        fleetCosts.add(currentFleetCost);

        Integer totalCost = fleetCosts.stream().mapToInt(Integer::intValue).sum();
        return totalCost;

        }
    }

