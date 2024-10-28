public class Animal {
    protected String name;
    public static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int length) {
        if (length < 0) {
            System.out.println("Длина препятствия не может быть отрицательной.");
        } else {
            System.out.println(name + " пробежал " + length + " м.");
        }
    }

    public void swim(int length) {
        if (length < 0) {
            System.out.println("Длина препятствия не может быть отрицательной.");
        } else {
            System.out.println(name + " проплыл " + length + " м.");
        }
    }
}