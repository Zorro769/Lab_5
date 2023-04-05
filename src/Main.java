public class Main {
    public static void main(String[] args) {
        Eagle.PrintCalr();
        Eagle eagle_1 = new Eagle();
        Eagle eagle_2 = new Eagle("duck");
        Eagle eagle_3 = new Eagle("wolf",30.5);
        Duck duck_1 = new Duck();
        Duck duck_2 = new Duck("eagle");
        Duck duck_3 = new Duck("worm",10.5);
        System.out.println("Check for equality: ");
        System.out.println(duck_2.ObjectEquals(duck_1));
        System.out.println(eagle_1.Eat());
        eagle_1.ChangeEat("fish");
        System.out.println(eagle_1.Eat());
        System.out.println(eagle_1.Move());
        System.out.println("---------------------------------------------------------");
        System.out.println(duck_1.Eat());
        duck_1.ChangeEat("worm");
        System.out.println(duck_1.Eat());
        System.out.println(duck_1.Move());
        System.out.println("---------------------------------------------------------");
        System.out.println(eagle_2.Eat());
        System.out.println(eagle_2.Move());
        System.out.println("---------------------------------------------------------");
        System.out.println(duck_2.Eat());
        System.out.println(duck_2.Move());
        System.out.println("---------------------------------------------------------");
        System.out.println(eagle_3.Move());
        System.out.println(eagle_3.Eat());
        System.out.println("---------------------------------------------------------");
        System.out.println(duck_3.Move());
        System.out.println(duck_3.Eat());
        System.out.println("---------------------------------------------------------");
        System.out.println(eagle_1.getEatName());
        System.out.println(eagle_1.getFamily());
        System.out.println(eagle_1.getSound());
        System.out.println("---------------------------------------------------------");
        System.out.println(duck_1.getEatName());
        System.out.println(duck_1.getFamily());
        System.out.println(duck_1.getSound());
        System.out.println("---------------------------------------------------------");
        Eagle.PrintCalr();
    }
}
abstract class Bird {
    protected String eat;
    abstract String Eat();
    abstract String Move();
    abstract void ChangeEat(String newFood);
}

class Eagle extends Bird implements IAnimal{

    private double flySpeed;
    static public double Calories;
    static
    {
        Calories = 10;
    }
    {
        eat = "Fish";
        flySpeed = 7;
    }

    public Eagle() {
        eat = "chickens";
        setFlySpeed(5);
        Calories += 20;
    }
    public Eagle(String food,Double... speed)
    {
        eat = food;
        if(speed.length > 0)
            this.flySpeed = speed[0];
        else
            this.flySpeed = 10;
        Calories += 30;
    }
    public double getFlySpeed()
    {
        return flySpeed;
    }
    public void setFlySpeed(double value)
    {
        flySpeed = value;
    }
    static void PrintCalr()
    {
        System.out.println("Eagle's calories: " + Calories);
    }
    @Override
    String Eat() {
        return ("Eagle is eating " + eat);
    }

    @Override
    String Move() {
        return ("Eagle is moving with the speed: " + flySpeed);
    }

    @Override
    void ChangeEat(String newFood) {
        this.eat = newFood;
        System.out.println("The eat has been changed ");
    }
    @Override
    public String getEatName()
    {
        return eat;
    }
    @Override
    public String getSound()
    {
        return "screeee";
    }
    @Override
    public String getFamily()
    {
        return "Accipitridae";
    }
}
class Duck extends Bird implements IAnimal{
    private double footSpeed;
    Duck(){
        eat = "Wheat";
        setFootSpeed(5);
    }
    Duck(String food,Double... speed)
    {
        eat = food;
        if(speed.length > 0)
        {
            this.footSpeed = speed[0];
        }
        else
        {
            this.footSpeed = 10;
        }
    }
    double getFootSpeed()
    {
        return footSpeed;
    }
    void setFootSpeed(double value)
    {
        footSpeed = value;
    }
    boolean ObjectEquals(Duck obj)
    {
        return footSpeed == obj.footSpeed;
    }
    @Override
    String Move() {
        return ("Duck is moving with the speed " + footSpeed);
    }

    @Override
    void ChangeEat(String newFood) {
        this.eat = newFood;
        System.out.println("The eat has been changed ");
    }

    @Override
    String Eat() {
        return ("Duck is eating " + eat);
    }
    @Override
    public String getEatName()
    {
        return eat;
    }
    @Override
    public String getSound()
    {
        return "Quaackk";
    }
    @Override
    public String getFamily() {
        return "Anatidae";
    }
}
interface IAnimal
{
    public String getEatName();
    public String getSound();
    public String getFamily();
}