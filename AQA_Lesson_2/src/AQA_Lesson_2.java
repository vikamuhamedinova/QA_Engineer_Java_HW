public class AQA_Lesson_2 {

    public static void main(String[] args) {
        Employee employeeArr[] = new Employee[5];
        employeeArr[0] = new Employee("Ivanov Ivan Pavlovich", "Electrician","ivanov@maildd.ru",
                "892383659", 30000, 27);
        employeeArr[1] = new Employee("Petrov Pavel Ignatievich", "Engineer","petrov@maildd.ru",
                "892335774", 50000, 37);
        employeeArr[2] = new Employee("Bubnova Inna Viktorovna", "Administrator","bubnova@maildd.ru",
                "892324684", 45000, 31);
        employeeArr[3] = new Employee("Vasechkin Petr Fedorovich", "Secretary","vasechkin@maildd.ru",
                "892326478", 55000, 40);
        employeeArr[4] = new Employee("Zaitsev Vladimir Ivanovich", "Director","zaitsev@maildd.ru",
                "892319533", 100000, 56);

        for (int i = 0; i < employeeArr.length; i++)
            employeeArr[i].display();

        Park park = new Park("Central Park");

    }
}
