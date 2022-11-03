package Animals;

public class ChineseGardenDog extends Animal {

    String name;
    int age;
    String sex;
    double weight;
    double price;

    public ChineseGardenDog(String name, int age, String sex, double weight, double price) {
        super(name, age, sex, weight, price);
    }

    @Override
    public String toString() {
        return "品种:" + name + "\n"
                + "年龄:" + age + "\n"
                + "性别:" + sex + "\n"
                + "体重:" + weight + "\n"
                + "性格:" + price + "\n";
    }


}
