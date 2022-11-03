package Animals;

public abstract class Animal {

    String name;
    int age;
    String sex;
    double weight;
    double price;

    public Animal(String name, int age, String sex, double weight, double price) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public abstract String toString();

}
