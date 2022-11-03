package AnimalShop;

import Animals.Animal;
import Animals.Cat;
import Animals.ChineseGardenDog;

import java.time.LocalTime;
import java.util.ArrayList;

public class Customer {

    String customerName;
    int numberOfArrivals;
    LocalTime latestArrivalTime;
    ArrayList<Animal> purchased;
    int cgdQuantity;
    int catQuantity;

    public Customer(String customerName) {
        this.customerName = customerName;
        purchased = new ArrayList<>();
    }

    String statisticsOfPurchaseInformation() {
        cgdQuantity = 0;
        catQuantity = 0;
        for (Animal animal : purchased) {
            if(animal.getClass().equals(ChineseGardenDog.class))
                cgdQuantity++;
            else if(animal.getClass().equals(Cat.class))
                catQuantity++;
        }
        if(cgdQuantity == 0 &&catQuantity == 0)
            return "无购买记录";
        return "已购买:\n"+"中华田园犬" + cgdQuantity + "条,"
                +"猫猫" + catQuantity + "条";
    }

    public void setLatestArrivalTime(LocalTime latestArrivalTime) {
        this.latestArrivalTime = latestArrivalTime;
    }

    public void addPurchased(Animal newAnimal) {
        purchased.add(newAnimal);
    }

    public void addNumberOfArrivals() {
        numberOfArrivals++;
    }

    @Override
    public String toString() {
        return "姓名:" + customerName + "\n"
                + "到店次数:" + numberOfArrivals + "\n"
                + "最新到店时间:" + latestArrivalTime + "\n"
                + statisticsOfPurchaseInformation() + "\n";
    }
}
