public class Dog extends Animal {
    public static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    public void run(int length) {
        if (length < 0) {
            System.out.println("Длина препятствия не может быть отрицательной.");
        } else if (length <= 500) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 500 м.");
        }
    }

    public void swim(int length) {
        if (length < 0) {
            System.out.println("Длина препятствия не может быть отрицательной.");
        } else if (length <= 10) {
            System.out.println(name + " проплыл " + length + " м.");
        } else {
            System.out.println(name + " не может проплыть больше 10 м.");
        }
    }
}