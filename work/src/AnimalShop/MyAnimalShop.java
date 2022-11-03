package AnimalShop;

import Animals.Animal;
import MyException.AnimalNotFountException;
import MyException.InsufficientBalanceException;

import java.time.LocalTime;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop{

    private double balance;
    private double profit;
    ArrayList<Animal> animals;
    ArrayList<Customer> customers;
    boolean isBusiness;
    int index;
    int numberOfCustomers;

    public MyAnimalShop(double balance) {
        this.balance = balance;
        this.profit = 0;
        this.animals = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.isBusiness = true;
        index = 0;
        numberOfCustomers = 0;
    }

    @Override
    public void purchaseOfNewAnimals(Animal newAnimal,int quantity) throws InsufficientBalanceException {

        if(newAnimal.getPrice() * quantity > balance) throw new InsufficientBalanceException("余额不足",newAnimal.getPrice() * quantity,balance);

        else {

            balance -= newAnimal.getPrice() * quantity;
            profit -= newAnimal.getPrice() * quantity;
            for (int i = 0; i < quantity; i++) {
                animals.add(newAnimal);
            }
            System.out.println("宠物店购入" + newAnimal.getName() + quantity + "只");

        }

    }

    @Override
    public void entertainCustomers(Customer customer,Animal animalsWantToBuy,LocalTime arriveTime) throws AnimalNotFountException{

        customers.add(customer);

        if(!animals.contains(animalsWantToBuy)) {
            customer.setLatestArrivalTime(arriveTime);
            customer.addNumberOfArrivals();
            numberOfCustomers++;
            throw new AnimalNotFountException("店里没有顾客想要买的动物");
        }
        else {

            balance += animalsWantToBuy.getPrice() * 1.1;
            profit += animalsWantToBuy.getPrice() * 0.1;
            animals.remove(animalsWantToBuy);
            customer.addPurchased(animalsWantToBuy);
            customer.setLatestArrivalTime(arriveTime);
            numberOfCustomers++;
            customer.addNumberOfArrivals();
            System.out.println("出售一只" + animalsWantToBuy.getName() + "成功!");

        }

    }

    @Override
    public void closure() {

        isBusiness = false;

        if(index == numberOfCustomers)
            System.out.println("今日没有顾客");
        else {
            ArrayList<Customer> t = new ArrayList<>();
            System.out.println("\n今日顾客:\n");
            for (; index < numberOfCustomers; index++) {
                if(!t.contains(customers.get(index))) {
                    t.add(customers.get(index));
                    System.out.println(customers.get(index));
                }
            }
        }

        System.out.println("今日利润:" + profit + "\n");

        profit = 0;

    }

    public void open() {
        isBusiness = true;
    }

}
