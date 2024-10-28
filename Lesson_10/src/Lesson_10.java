public class Lesson_10 {
    public static void main(String[] args) {
        //1
        Animal tiger = new Animal("Тигр");
        Cat catBarsik = new Cat("Барсик");
        Dog dogSharik = new Dog("Шарик");
        tiger.run(700);
        catBarsik.run(200);
        dogSharik.run(500);
        tiger.swim(70);
        catBarsik.swim(20);
        dogSharik.swim(10);
        System.out.println(Animal.count);
        System.out.println(Cat.count);
        System.out.println(Dog.count);
        Bowl bowl = new Bowl();
        bowl.addAmountFood(65);
        System.out.println(bowl.getAmountFood());
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Сима");
        cats[1] = new Cat("Сема");
        cats[2] = new Cat("Фифа");
        cats[3] = new Cat("Шуша");
        cats[4] = new Cat("Цыля");
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl, 20);
            cats[i].satietyInfo();
            System.out.println(bowl.getAmountFood());
        }

        //2
        Circle circle = new Circle(3);
        circle.setBackgroundColor("Red");
        circle.setBorderColor("Red");
        circle.displayInfo();
        Rectangle rectangle = new Rectangle(2, 5);
        rectangle.setBackgroundColor("Blue");
        rectangle.setBorderColor("Yellow");
        rectangle.displayInfo();
        Triangle triangle = new Triangle(2, 3, 4);
        triangle.setBackgroundColor("Green");
        triangle.setBorderColor("Black");
        triangle.displayInfo();
    }
}