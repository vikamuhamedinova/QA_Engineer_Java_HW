public class Cat extends Animal {
    public static int count = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        satiety = false;
        count++;
    }

    public void run(int length) {
        if (length < 0) {
            System.out.println("Длина препятствия не может быть отрицательной.");
        } else if (length <= 200) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 200 м.");
        }
    }

    public void swim(int length) {
        if (length < 0) {
            System.out.println("Длина препятствия не может быть отрицательной.");
        } else {
            System.out.println("Кот не умеет плавать.");
        }
    }

    public void eat(Bowl bowl, int portionSize) {
        if (portionSize <= 0) {
            System.out.println("Размер съедаемой порции не может быть меньше 0.");
        } else if (bowl.getAmountFood() - portionSize >= 0) {
            satiety = true;
            bowl.setAmountFood(bowl.getAmountFood() - portionSize);
        }
    }

    public void satietyInfo() {
        if (satiety) {
            System.out.println("Кот сыт.");
        } else {
            System.out.println("Кот голоден.");
        }
    }
}