import AnimalShop.Customer;
import AnimalShop.MyAnimalShop;
import Animals.Cat;
import Animals.ChineseGardenDog;
import MyException.AnimalNotFountException;
import MyException.InsufficientBalanceException;

import java.time.LocalTime;

public class test {

    public static void main(String[] args) {

        final double INITIAL_BALANCE = 2000;
        final double CHINESE_GARDEN_DOG_PRICE = 100;
        final double CAT_PRICE = 200;
        final String CHINESE_GARDEN_DOG_NAME = "中华田园犬";
        final String CAT_NAME = "猫猫";

        MyAnimalShop shop = new MyAnimalShop(INITIAL_BALANCE);

        //初始化五个顾客
        Customer c1 = new Customer("张三");
        Customer c2 = new Customer("李四");
        Customer c3 = new Customer("王五");
        Customer c4 = new Customer("赵六");
        Customer c5 = new Customer("孙七");

        //六种中华田园犬
        ChineseGardenDog dog1 = new ChineseGardenDog(CHINESE_GARDEN_DOG_NAME, 1, "公", 10, CHINESE_GARDEN_DOG_PRICE);
        ChineseGardenDog dog2 = new ChineseGardenDog(CHINESE_GARDEN_DOG_NAME, 2, "公", 15, CHINESE_GARDEN_DOG_PRICE);
        ChineseGardenDog dog3 = new ChineseGardenDog(CHINESE_GARDEN_DOG_NAME, 3, "公", 20, CHINESE_GARDEN_DOG_PRICE);
        ChineseGardenDog dog4 = new ChineseGardenDog(CHINESE_GARDEN_DOG_NAME, 1, "母", 10, CHINESE_GARDEN_DOG_PRICE);
        ChineseGardenDog dog5 = new ChineseGardenDog(CHINESE_GARDEN_DOG_NAME, 2, "母", 15, CHINESE_GARDEN_DOG_PRICE);
        ChineseGardenDog dog6 = new ChineseGardenDog(CHINESE_GARDEN_DOG_NAME, 3, "母", 20, CHINESE_GARDEN_DOG_PRICE);

        //六种猫猫
        Cat cat1 = new Cat(CAT_NAME, 1, "公", 5, CAT_PRICE);
        Cat cat2 = new Cat(CAT_NAME, 2, "公", 8, CAT_PRICE);
        Cat cat3 = new Cat(CAT_NAME, 3, "公", 12, CAT_PRICE);
        Cat cat4 = new Cat(CAT_NAME, 1, "母", 5, CAT_PRICE);
        Cat cat5 = new Cat(CAT_NAME, 2, "母", 8, CAT_PRICE);
        Cat cat6 = new Cat(CAT_NAME, 3, "母", 12, CAT_PRICE);

        //购入若干只动物
        System.out.println("第一天");

        try {
            shop.purchaseOfNewAnimals(dog2,2);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        try {
            shop.purchaseOfNewAnimals(dog6,3);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        try {
            shop.purchaseOfNewAnimals(cat1,1);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        try {
            shop.purchaseOfNewAnimals(cat3,1);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        try {
            shop.purchaseOfNewAnimals(cat6,2);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        //出售若干只动物
        try {
            shop.entertainCustomers(c1,dog2,LocalTime.now());
        } catch (AnimalNotFountException e) {
            System.out.println(e);
        }

        try {
            shop.entertainCustomers(c2,dog6,LocalTime.now());
        } catch (AnimalNotFountException e) {
            System.out.println(e);
        }

        try {
            shop.entertainCustomers(c3,cat2,LocalTime.now());
        } catch (AnimalNotFountException e) {
            System.out.println(e);
        }

        shop.closure();

        System.out.println("==============================================================\n");
        System.out.println("第二天");
        shop.open();
        try {
            shop.entertainCustomers(c1,dog3,LocalTime.now());
        } catch (AnimalNotFountException e) {
            System.out.println(e);
        }

        try {
            shop.entertainCustomers(c4,dog6,LocalTime.now());
        } catch (AnimalNotFountException e) {
            System.out.println(e);
        }

        try {
            shop.entertainCustomers(c5,cat1,LocalTime.now());
        } catch (AnimalNotFountException e) {
            System.out.println(e);
        }

        shop.closure();

        System.out.println("==============================================================\n");
        System.out.println("第三天");
        try {
            shop.purchaseOfNewAnimals(dog1,3);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        try {
            shop.purchaseOfNewAnimals(dog5,1);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        try {
            shop.purchaseOfNewAnimals(cat5,5);
        } catch (InsufficientBalanceException e) {
            System.out.println(e);
        }

        shop.closure();

    }

}
