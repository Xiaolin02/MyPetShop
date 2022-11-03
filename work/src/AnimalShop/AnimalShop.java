package AnimalShop;

import Animals.Animal;

import java.time.LocalTime;

public interface AnimalShop {

    void purchaseOfNewAnimals(Animal newAnimal,int quantity);

    void entertainCustomers(Customer customer,Animal animalsWantToBuy,LocalTime arriveTime);

    void closure();

}
